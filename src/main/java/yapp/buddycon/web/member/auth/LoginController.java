package yapp.buddycon.web.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
