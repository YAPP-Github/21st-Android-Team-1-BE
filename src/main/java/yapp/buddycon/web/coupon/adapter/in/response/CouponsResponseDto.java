package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;

public record CouponsResponseDto(
  Long id,
  String path,
  String name,
  LocalDate expireDate
) {
}
