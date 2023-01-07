package yapp.buddycon.member.auth;

public record ReissueRequestDto(
  String accessToken,
  String refreshToken
) {
}
