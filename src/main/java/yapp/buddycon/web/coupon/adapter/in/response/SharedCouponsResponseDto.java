package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record SharedCouponsResponseDto(
  Long id,
  String imageUrl,
  String name,
  LocalDate expireDate,
  boolean shared
) {
}
