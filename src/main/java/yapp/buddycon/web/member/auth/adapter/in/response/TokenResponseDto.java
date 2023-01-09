package yapp.buddycon.web.member.auth.adapter.in.response;

public record TokenResponseDto(
  String grantType,
  String accessToken,
//  String refreshToken,
  Long accessTokenExpiresIn
) {
}
