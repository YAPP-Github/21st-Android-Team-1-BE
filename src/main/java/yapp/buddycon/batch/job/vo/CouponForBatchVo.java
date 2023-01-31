package yapp.buddycon.batch.job.vo;

import java.sql.Date;

public record CouponForBatchVo(
    Long id,
    String name,
    Date expireDate,
    Long memberId
) {

}
