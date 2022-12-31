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

  private final AuthService loginService;

  @PostMapping("login/{accessToken}")
  public void login(@PathVariable String accessToken) {
    loginService.login(accessToken);
  }

}
