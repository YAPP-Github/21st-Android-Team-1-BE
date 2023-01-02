package yapp.buddycon.member.auth;

public record ReissueRequest(
  String accessToken,
  String refreshToken
) {
}
