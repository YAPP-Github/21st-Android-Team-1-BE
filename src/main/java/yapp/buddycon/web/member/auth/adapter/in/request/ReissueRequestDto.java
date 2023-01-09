package yapp.buddycon.web.member.auth.adapter.in.request;

public record ReissueRequestDto(
  String accessToken,
  String refreshToken
) {
}
