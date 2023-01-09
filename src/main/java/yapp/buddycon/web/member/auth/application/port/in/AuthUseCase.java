package yapp.buddycon.web.member.auth.application.port.in;

import yapp.buddycon.web.member.auth.adapter.in.response.TokenResponseDto;

public interface AuthUseCase {
  TokenResponseDto login(String accessToken);
}
