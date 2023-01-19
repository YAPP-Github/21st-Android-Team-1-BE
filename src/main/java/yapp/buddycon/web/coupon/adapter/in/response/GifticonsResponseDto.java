package yapp.buddycon.web.coupon.adapter.in.response;

import java.util.Date;

public record GifticonsResponseDto(
  Long id,
  String path,
  String name,
  Date expireDate
) {
}
