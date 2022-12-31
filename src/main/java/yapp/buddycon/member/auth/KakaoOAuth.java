package yapp.buddycon.member.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import yapp.buddycon.exception.CustomException;
import yapp.buddycon.exception.ErrorCode;

@Component
public class KakaoOAuth {
  /**
   * curl -v -X POST "https://kapi.kakao.com/v2/user/me" \
   * -H "Content-Type: application/x-www-form-urlencoded" \
   * -H "Authorization: Bearer ${ACCESS_TOKEN}" \
   * --data-urlencode 'property_keys=["kakao_account.name"]'
   */
  private final WebClient webClient = WebClient.create("https://kapi.kakao.com/v2/user/me");

  public OAuthMember getUserAttributes(String accessToken) {
    return webClient.get()
      .headers(header -> { header.setBearerAuth(accessToken); })
      .retrieve()
      .bodyToMono(Kakao.class)
      .onErrorMap((error) -> new CustomException(ErrorCode.INVALID_KAKAO_ACCESS_TOKEN))
      .map(Kakao::toOAuthMember)
      .block();
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  record Kakao(
    Long id,
    KakaoNickname properties
  ){
    public OAuthMember toOAuthMember(){
      return new OAuthMember(id, properties().nickname());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  record KakaoNickname(
    String nickname
  ){}

}
