package yapp.buddycon.web.auth.application.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.auth.application.port.in.OAuthMemberInfo;
import yapp.buddycon.web.auth.application.port.in.KakaoOAuthUseCase;

@Component
@RequiredArgsConstructor
public class KakaoOAuthMapper {

  private final KakaoOAuthUseCase kakaoOAuthUseCase;

  public OAuthMemberInfo getUserAttributes(String accessToken) {
    return kakaoOAuthUseCase
      .getUserAttributes(accessToken)
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
    public OAuthMemberInfo toOAuthMember(){
      return new OAuthMemberInfo(id, properties().nickname());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  record KakaoNickname(
    String nickname
  ){}

}
