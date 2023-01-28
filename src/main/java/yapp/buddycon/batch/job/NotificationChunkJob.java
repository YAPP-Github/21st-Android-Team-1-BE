package yapp.buddycon.batch.job;

import java.time.LocalDate;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yapp.buddycon.batch.job.vo.CouponForBatchVo;
import yapp.buddycon.batch.job.vo.CouponForBatchVoRowMapper;
import yapp.buddycon.batch.job.vo.NotificationForBatchVo;

@RequiredArgsConstructor
@Configuration
public class NotificationChunkJob {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final DataSource dataSource;

  private final int CHUNK_SIZE = 5;
  private final String BASIC_QUERY_FOR_GET_COUPONS =
      "SELECT c.id, c.name, c.expire_date, c.member_id"
          + " FROM coupon AS c"
          + "   INNER JOIN member AS m"
          + "     ON c.member_id = m.id"
          + "   INNER JOIN notification_setting AS ns"
          + "     ON m.id = ns.member_id"
          + "   WHERE ns.activate = true ";

  @Bean
  public Job simpleNotificationChunkJob() {
    // TODO
    //  - 코드 중복 제거 How..?
    //  - 성능 최적화 (Paging Query) https://youtu.be/2IIwQDIi3ys

    Step stepForFourteenDaysLeft = stepBuilderFactory.get("stepForFourteenDaysLeft")
        .<CouponForBatchVo, NotificationForBatchVo> chunk(CHUNK_SIZE)
          .reader(couponChunkReaderForFourteenDaysLeft())
          .processor(notificationChunkProcessor())
          .writer(notificationChunkWriter())
        .faultTolerant()
        .skipLimit(CHUNK_SIZE)
        .skip(Exception.class)
        .build();

    Step stepForSevenDaysLeft = stepBuilderFactory.get("stepForSevenDaysLeft")
        .<CouponForBatchVo, NotificationForBatchVo> chunk(CHUNK_SIZE)
          .reader(couponChunkReaderForSevenDaysLeft())
          .processor(notificationChunkProcessor())
          .writer(notificationChunkWriter())
        .faultTolerant()
        .skipLimit(CHUNK_SIZE)
        .skip(Exception.class)
        .build();

    Step stepForThreeDaysLeft = stepBuilderFactory.get("stepForThreeDaysLeft")
        .<CouponForBatchVo, NotificationForBatchVo> chunk(CHUNK_SIZE)
          .reader(couponChunkReaderForThreeDaysLeft())
          .processor(notificationChunkProcessor())
          .writer(notificationChunkWriter())
        .faultTolerant()
        .skipLimit(CHUNK_SIZE)
        .skip(Exception.class)
        .build();

    Step stepForOneDaysLeft = stepBuilderFactory.get("stepForOneDaysLeft")
        .<CouponForBatchVo, NotificationForBatchVo> chunk(CHUNK_SIZE)
          .reader(couponChunkReaderForOneDaysLeft())
          .processor(notificationChunkProcessor())
          .writer(notificationChunkWriter())
        .faultTolerant()
        .skipLimit(CHUNK_SIZE)
        .skip(Exception.class)
        .build();

    return jobBuilderFactory.get("simpleNotificationChunkJob")
        .incrementer(new RunIdIncrementer())
        .flow(stepForFourteenDaysLeft)
        .next(stepForSevenDaysLeft)
        .next(stepForThreeDaysLeft)
        .next(stepForOneDaysLeft)
        .end()
        .build();
  }

  @Bean
  public JdbcCursorItemReader<CouponForBatchVo> couponChunkReaderForFourteenDaysLeft() {
    return new JdbcCursorItemReaderBuilder<CouponForBatchVo>()
        .name("couponChunkReaderForFourteenDaysLeft")
        .dataSource(dataSource)
        .fetchSize(CHUNK_SIZE)
        .rowMapper(new CouponForBatchVoRowMapper())
        .sql(BASIC_QUERY_FOR_GET_COUPONS
            + "AND DATE(c.expire_date) = DATE(DATE_ADD(NOW(), INTERVAL 14 DAY)) "
            + "AND ns.fourteen_days_left = true")
        .build();
  }

  @Bean
  public JdbcCursorItemReader<CouponForBatchVo> couponChunkReaderForSevenDaysLeft() {
    return new JdbcCursorItemReaderBuilder<CouponForBatchVo>()
        .name("couponChunkReaderForSevenDaysLeft")
        .dataSource(dataSource)
        .fetchSize(CHUNK_SIZE)
        .rowMapper(new CouponForBatchVoRowMapper())
        .sql(BASIC_QUERY_FOR_GET_COUPONS
            + "AND DATE(c.expire_date) = DATE(DATE_ADD(NOW(), INTERVAL 7 DAY)) "
            + "AND ns.seven_days_left = true")
        .build();
  }

  @Bean
  public JdbcCursorItemReader<CouponForBatchVo> couponChunkReaderForThreeDaysLeft() {
    return new JdbcCursorItemReaderBuilder<CouponForBatchVo>()
        .name("couponChunkReaderForThreeDaysLeft")
        .dataSource(dataSource)
        .fetchSize(CHUNK_SIZE)
        .rowMapper(new CouponForBatchVoRowMapper())
        .sql(BASIC_QUERY_FOR_GET_COUPONS + "AND DATE(c.expire_date) = DATE(DATE_ADD(NOW(), INTERVAL 3 DAY)) "
            + "AND ns.three_days_left = true")
        .build();
  }

  @Bean
  public JdbcCursorItemReader<CouponForBatchVo> couponChunkReaderForOneDaysLeft() {
    return new JdbcCursorItemReaderBuilder<CouponForBatchVo>()
        .name("couponChunkReaderForOneDaysLeft")
        .dataSource(dataSource)
        .fetchSize(CHUNK_SIZE)
        .rowMapper(new CouponForBatchVoRowMapper())
        .sql(BASIC_QUERY_FOR_GET_COUPONS + "AND DATE(c.expire_date) = DATE(DATE_ADD(NOW(), INTERVAL 1 DAY)) "
            + "AND ns.one_days_left = true")
        .build();
  }

  @Bean
  public NotificationProcessor notificationChunkProcessor() {
    return new NotificationProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<NotificationForBatchVo> notificationChunkWriter() {
    return new JdbcBatchItemWriterBuilder<NotificationForBatchVo>()
        .dataSource(dataSource)
        .sql("INSERT INTO notification(created_at, updated_at, title, body, checked, member_id, coupon_id)"
            + "VALUES (:nowDateTime, :nowDateTime, :title, :body, :checked, :memberId, :couponId)")
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .build();
  }

}
