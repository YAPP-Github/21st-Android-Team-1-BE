package yapp.buddycon.web.member.auth.application.port.in;

import org.springframework.web.reactive.function.client.WebClient;

public interface KakaoOAuthUseCase {
  WebClient.ResponseSpec getUserAttributes(String accessToken);
}
