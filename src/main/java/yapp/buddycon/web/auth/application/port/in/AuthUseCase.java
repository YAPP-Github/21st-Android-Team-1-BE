package yapp.buddycon.web.auth.application.port.in;

import yapp.buddycon.web.auth.adapter.in.request.KakaoInfoRequestDto;
import yapp.buddycon.web.auth.adapter.in.request.ReissueRequestDto;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;

public interface AuthUseCase {
  TokenResponseDto login(KakaoInfoRequestDto kakaoInfoRequestDto);
  TokenResponseDto reissue(ReissueRequestDto reissueRequestDto);
}
