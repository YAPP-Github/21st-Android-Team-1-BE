package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

public record SharedCustomCouponResponseDto(
  Long id,
  String imageUrl,
  String barcode,
  String name,
  LocalDate expireDate,
  String storeName,
  String sentMemberName,
  String memo
) {

  public static SharedCustomCouponResponseDto valueOf(SharedCoupon sharedCoupon) {
    return new SharedCustomCouponResponseDto(
        sharedCoupon.getId(),
        sharedCoupon.getSharedCouponInfo().getImageUrl(),
        sharedCoupon.getSharedCouponInfo().getBarcode(),
        sharedCoupon.getSharedCouponInfo().getName(),
        sharedCoupon.getSharedCouponInfo().getExpireDate(),
        sharedCoupon.getSharedCouponInfo().getStoreName(),
        sharedCoupon.getSharedCouponInfo().getSentMember().getName(),
        sharedCoupon.getSharedCouponInfo().getMemo()
    );
  }

}
