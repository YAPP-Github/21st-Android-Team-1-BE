package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record SharedCouponsResponseDto(
  Long id,
  String path,
  String name,
  LocalDate expireDate,
  boolean shared
) {
}
