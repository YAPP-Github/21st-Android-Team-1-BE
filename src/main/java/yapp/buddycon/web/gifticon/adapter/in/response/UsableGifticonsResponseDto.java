package yapp.buddycon.web.gifticon.adapter.in.response;

public record UsableGifticonsResponseDto(
  Long id,
  String path,
  String name,
  String expireDate,
  Integer leftDate
) {
}
