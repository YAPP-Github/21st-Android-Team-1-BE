package yapp.buddycon.batch.job;

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

  @Bean
  public Job simpleNotificationChunkJob() {
    return jobBuilderFactory.get("simpleNotificationChunkJob")
        .incrementer(new RunIdIncrementer())
        .start(notificationChunkStep())
        .build();
  }

  @Bean
  public Step notificationChunkStep() {
    return stepBuilderFactory.get("notificationChunkStep")
        .<CouponForBatchVo, NotificationForBatchVo> chunk(CHUNK_SIZE)
        .reader(couponChunkReader())
        .processor(notificationChunkProcessor())
        .writer(notificationChunkWriter())
        .build();
  }

  @Bean
  public JdbcCursorItemReader<CouponForBatchVo> couponChunkReader() {
    return new JdbcCursorItemReaderBuilder<CouponForBatchVo>()
        .name("couponChunkReader")
        .dataSource(dataSource)
        .fetchSize(CHUNK_SIZE)
        .rowMapper(new CouponForBatchVoRowMapper())
        .sql("SELECT id, name, expire_date, member_id FROM coupon")
        .build();
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

  @Bean
  public NotificationProcessor notificationChunkProcessor() {
    return new NotificationProcessor();
  }

}
