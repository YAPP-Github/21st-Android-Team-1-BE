package yapp.buddycon.web.auth.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;
import yapp.buddycon.web.auth.application.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class LoginController {

  private final AuthService authService;

  @PostMapping("login/{accessToken}")
  public TokenResponseDto login(@PathVariable String accessToken) {
    return authService.login(accessToken);
  }

//  @PostMapping("reissue")
//  public TokenResponseDto reissue(@RequestBody ReissueRequestDto reissueRequestDto) {
//    return authService.reissue(reissueRequestDto);
//  }

}