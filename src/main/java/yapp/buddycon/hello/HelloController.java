package yapp.buddycon.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.auth.adapter.out.AuthMember;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

  @GetMapping
  public HelloResponseDto hello(AuthMember authMember) {
    return new HelloResponseDto("hello! your id is " + authMember.id());
  }

  record HelloResponseDto(
    String message
  ){}

}
