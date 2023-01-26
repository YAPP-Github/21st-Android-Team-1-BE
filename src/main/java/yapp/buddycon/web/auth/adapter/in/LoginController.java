package yapp.buddycon.web.auth.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yapp.buddycon.web.auth.adapter.in.request.KakaoInfoRequestDto;
import yapp.buddycon.web.auth.adapter.in.request.ReissueRequestDto;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;
import yapp.buddycon.web.auth.application.port.in.AuthUseCase;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class LoginController {

  private final AuthUseCase authUseCase;

  @PostMapping("/login")
  @Operation(summary = "로그인", description = "최초 로그인일 경우 회원가입 처리")
  public TokenResponseDto login(@RequestBody @Valid KakaoInfoRequestDto kakaoInfoRequestDto) {
    return authUseCase.login(kakaoInfoRequestDto);
  }

  @PostMapping("/reissue")
  public TokenResponseDto reissue(@RequestBody ReissueRequestDto reissueRequestDto) {
    return authUseCase.reissue(reissueRequestDto);
  }

}
