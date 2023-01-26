package yapp.buddycon.web.auth.adapter.in.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public record KakaoInfoRequestDto(
  @NotEmpty
  String accessToken,
  @Email
  String email,
  @NotEmpty
  String name,

  String gender,
  String ageRange
) {
}
