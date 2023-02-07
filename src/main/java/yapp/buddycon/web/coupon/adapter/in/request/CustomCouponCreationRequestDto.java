package yapp.buddycon.web.coupon.adapter.in.request;

import java.time.LocalDate;

public record CustomCouponCreationRequestDto(
  String barcode,
  String name,
  LocalDate expireDate,
  String storeName,
  String memo,
  String sentMemberName
) {
}
