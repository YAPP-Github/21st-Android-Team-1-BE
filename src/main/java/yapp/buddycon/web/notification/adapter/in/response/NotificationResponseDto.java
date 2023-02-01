package yapp.buddycon.web.notification.adapter.in.response;

import java.time.LocalDate;
import yapp.buddycon.web.coupon.domain.CouponType;
import yapp.buddycon.web.notification.domain.Notification;

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

  public static NotificationResponseDto valueOf(Notification notification) {
    return new NotificationResponseDto(
        notification.getId(),
        notification.getTitle(),
        notification.getBody(),
        notification.isChecked(),
        notification.getCoupon() == null ? null :
            notification.getCoupon().getId(),
        notification.getCoupon() == null ? null :
            notification.getCoupon().getCouponType(),
        notification.getCoupon() == null ? null :
            notification.getCoupon().getCouponInfo().getName(),
        notification.getCoupon() == null ? null :
            notification.getCoupon().getCouponInfo().getExpireDate()
    );
  }

}
