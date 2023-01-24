package yapp.buddycon.web.auth.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yapp.buddycon.web.auth.adapter.in.request.ReissueRequestDto;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;
import yapp.buddycon.web.auth.application.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class LoginController {

  private final AuthService authService;

  @PostMapping("login/{accessToken}")
  @Operation(summary = "로그인", description = "최초 로그인일 경우 회원가입 처리")
  public TokenResponseDto login(@PathVariable String accessToken) {
    return authService.login(accessToken);
  }

  @PostMapping("reissue")
  public TokenResponseDto reissue(@RequestBody ReissueRequestDto reissueRequestDto) {
    return authService.reissue(reissueRequestDto);
  }

}
