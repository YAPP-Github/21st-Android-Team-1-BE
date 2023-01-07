package yapp.buddycon.web.member.auth;

public record ReissueRequestDto(
  String accessToken,
  String refreshToken
) {
}
