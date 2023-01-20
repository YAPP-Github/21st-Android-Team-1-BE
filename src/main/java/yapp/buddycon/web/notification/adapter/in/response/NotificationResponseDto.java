package yapp.buddycon.web.notification.adapter.in.response;

import java.time.LocalDate;
import yapp.buddycon.web.coupon.domain.CouponState;
import yapp.buddycon.web.coupon.domain.CouponType;

public record NotificationResponseDto(
    // notification
    Long id,
    String title,
    String body,
    boolean checked,

    // coupon
    Long couponId,
    CouponState couponState,
    CouponType couponType,
    String couponImageUrl,
    String couponName,
    String couponMemo,
    String storeName,
    String sentMemberName,
    LocalDate expireDate
) {

}
