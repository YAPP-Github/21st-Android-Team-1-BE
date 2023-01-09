package yapp.buddycon.web.auth.application.port.in;

import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;

public interface AuthUseCase {
  TokenResponseDto login(String accessToken);
}
