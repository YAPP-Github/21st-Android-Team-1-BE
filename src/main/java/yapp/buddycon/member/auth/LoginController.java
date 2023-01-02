package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class LoginController {

  private final AuthService authService;

  @PostMapping("login/{accessToken}")
  public TokenResponse login(@PathVariable String accessToken) {
    return authService.login(accessToken);
  }

  @PostMapping("reissue")
  public TokenResponse reissue(@RequestBody ReissueRequest reissueRequest) {
    return authService.reissue(reissueRequest);
  }

}
