package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record GifticonInfoResponseDto(
  String imageUrl,
  String name,
  LocalDate expireDate,
  String storeName,
  String memo,
  boolean isMoneyCoupon,
  Integer leftMoney
) {
}
