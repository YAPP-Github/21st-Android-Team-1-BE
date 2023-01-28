package yapp.buddycon.batch.job;

import java.time.LocalDateTime;
import org.springframework.batch.item.ItemProcessor;
import yapp.buddycon.batch.job.vo.CouponForBatchVo;
import yapp.buddycon.batch.job.vo.NotificationForBatchVo;

public class NotificationProcessor implements
    ItemProcessor<CouponForBatchVo, NotificationForBatchVo> {

  public NotificationForBatchVo process(CouponForBatchVo vo) throws Exception {

//    Thread.sleep(1000);

    return new NotificationForBatchVo(
        vo.name() + "title",
        vo.name() + " body",
        true,
        vo.memberId(),
        vo.id(),
        LocalDateTime.now()
    );
  }

}
