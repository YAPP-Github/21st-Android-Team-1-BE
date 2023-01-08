package yapp.buddycon.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.member.auth.AuthMember;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

  @GetMapping
  public String hello(AuthMember authMember) {
    return "hi buddy" + authMember.id() + "~";
  }

}
