package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class LoginController {

  private final AuthService authService;

  @PostMapping("login/{accessToken}")
  public TokenResponse login(@PathVariable String accessToken) {
    return authService.login(accessToken);
  }
//
//  @PostMapping("reissue")
//  public TokenResponse reissue(AuthMember authMember) {
//    return authService.reissue(authMember);
//  }

}
