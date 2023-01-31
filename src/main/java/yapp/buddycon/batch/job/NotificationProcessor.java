package yapp.buddycon.batch.job;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.batch.item.ItemProcessor;
import yapp.buddycon.batch.job.vo.CouponForBatchVo;
import yapp.buddycon.batch.job.vo.NotificationForBatchVo;

public class NotificationProcessor implements
    ItemProcessor<CouponForBatchVo, NotificationForBatchVo> {

  public NotificationForBatchVo process(CouponForBatchVo vo) throws Exception {

    long dateDiff = ChronoUnit.DAYS.between(LocalDate.now(), vo.expireDate().toLocalDate());

    // TODO 삭제 필요 (chunk 테스트용)
//    Thread.sleep(1000);
//    if (vo.id() == 12) throw new Exception("hi");

    return new NotificationForBatchVo(
        "'" + vo.name() + "'" + " 만료일이 " + dateDiff + "일 남았어요.",
        null,
        false,
        vo.memberId(),
        vo.id(),
        LocalDateTime.now()
    );
  }

}
