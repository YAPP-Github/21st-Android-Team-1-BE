package yapp.buddycon.batch.job.vo;

import java.time.LocalDateTime;

public record NotificationForBatchVo(
    String title,
    String body,
    boolean checked,
    Long memberId,
    Long couponId,
    LocalDateTime nowDateTime
) {

}
