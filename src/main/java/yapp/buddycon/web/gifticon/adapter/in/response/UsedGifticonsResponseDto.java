package yapp.buddycon.web.gifticon.adapter.in.response;

public record UsedGifticonsResponseDto(
  Long id,
  String path,
  String name,
  String expireDate
) {
}
