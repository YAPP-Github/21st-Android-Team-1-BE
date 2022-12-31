package yapp.buddycon.member.auth;

public record TokenResponse(
  String grantType,
  String accessToken,
  String refreshToken,
  Long accessTokenExpiresIn
) {
}
