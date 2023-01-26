package yapp.buddycon.web.coupon.adapter.in.request;

import java.time.LocalDate;

public record GifticonInfoRequestDto(
  String name,
  LocalDate expireDate,
  String storeName,
  String memo,
  boolean isMoneyCoupon,
  Integer leftMoney
) {
}
