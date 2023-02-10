package yapp.buddycon.web.coupon.adapter.in.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CouponsResponseDto(
  Long id,
  String imageUrl,
  String name,
  LocalDate expireDate,
  LocalDateTime createdAt
) {
}