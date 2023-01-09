package yapp.buddycon.web.member.auth.adapter.out;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import yapp.buddycon.web.member.auth.application.port.in.KakaoOAuthUseCase;

@Component
public class KakaoUserInfoApi implements KakaoOAuthUseCase {

  private final WebClient webClient = WebClient.create("https://kapi.kakao.com/v2/user/me");

  @Override
  public WebClient.ResponseSpec getUserAttributes(String accessToken) {
    return webClient.get()
      .headers(header -> {
        header.setBearerAuth(accessToken);
      })
      .retrieve();
  }
}
