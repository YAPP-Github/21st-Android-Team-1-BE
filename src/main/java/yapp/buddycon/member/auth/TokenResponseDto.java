package yapp.buddycon.member.auth;

public record TokenResponseDto(
  String grantType,
  String accessToken,
//  String refreshToken,
  Long accessTokenExpiresIn
) {
}
