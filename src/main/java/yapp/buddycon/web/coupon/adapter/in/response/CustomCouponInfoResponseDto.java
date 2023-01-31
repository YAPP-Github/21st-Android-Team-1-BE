package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record CustomCouponInfoResponseDto(
  Long id,
  String imageUrl,
  String barcode,
  String name,
  LocalDate expireDate,
  String storeName,
  String sentMemberName,
  String memo
) {
}
