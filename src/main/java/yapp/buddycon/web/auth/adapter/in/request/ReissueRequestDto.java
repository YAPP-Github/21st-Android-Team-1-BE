package yapp.buddycon.web.auth.adapter.in.request;

public record ReissueRequestDto(
  String accessToken,
  String refreshToken
) {
}
