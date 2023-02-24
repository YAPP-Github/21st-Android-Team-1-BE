package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

public record SharedGifticonInfoResponseDto(
  Long id,
  String imageUrl,
  String barcode,
  String name,
  LocalDate expireDate,
  String storeName,
  String memo
) {

  public static SharedGifticonInfoResponseDto valueOf(SharedCoupon sharedCoupon) {
    return new SharedGifticonInfoResponseDto(
        sharedCoupon.getId(),
        sharedCoupon.getSharedCouponInfo().getImageUrl(),
        sharedCoupon.getSharedCouponInfo().getBarcode(),
        sharedCoupon.getSharedCouponInfo().getName(),
        sharedCoupon.getSharedCouponInfo().getExpireDate(),
        sharedCoupon.getSharedCouponInfo().getStoreName(),
        sharedCoupon.getSharedCouponInfo().getMemo()
    );
  }

}
