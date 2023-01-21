package yapp.buddycon.web.notification.adapter.in.response;

import java.time.LocalDate;
import yapp.buddycon.web.coupon.domain.CouponType;

public record NotificationResponseDto(
    // notification
    Long id,
    String title,
    String body,
    boolean checked,

    // coupon
    Long couponId,
    CouponType couponType,
    String couponName,
    LocalDate expireDate
) {

}
