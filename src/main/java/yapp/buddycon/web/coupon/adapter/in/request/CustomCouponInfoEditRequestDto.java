package yapp.buddycon.web.coupon.adapter.in.request;

import java.time.LocalDate;

public record CustomCouponInfoEditRequestDto(
  String name,
  LocalDate expireDate,
  String storeName,
  String sentMemberName,
  String memo
) {
}
