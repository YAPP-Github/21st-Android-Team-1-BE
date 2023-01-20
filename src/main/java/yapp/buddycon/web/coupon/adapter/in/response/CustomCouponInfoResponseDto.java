package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record CustomCouponInfoResponseDto(
  String imageUrl,
  String name,
  LocalDate expireDate,
  String storeName,
  String sentMemberName,
  String memo
) {
}
