package yapp.buddycon.web.gifticon.adapter.in.response;

import java.util.Date;

public record GifticonsResponseDto(
  Long id,
  String path,
  String name,
  Date expireDate
) {
}
