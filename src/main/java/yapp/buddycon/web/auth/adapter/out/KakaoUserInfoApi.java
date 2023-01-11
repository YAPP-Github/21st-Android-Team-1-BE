package yapp.buddycon.web.auth.adapter.out;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import yapp.buddycon.web.auth.application.port.in.KakaoOAuthUseCase;

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
