package yapp.buddycon.web.member.auth.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import yapp.buddycon.common.domain.AuthMember;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.member.auth.application.service.TokenDecoder;

@Component
@RequiredArgsConstructor
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

  @Value("${security.jwt.token.bearer-type}")
  private String BEARER_TYPE;

  private final TokenDecoder decoder;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType() == AuthMember.class;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String bearerToken = webRequest.getHeader("Authorization");
    validateBearerToken(bearerToken);
    Long id = decoder.decode(bearerToken.split(" ")[1].trim()).getBody().get("memberId", Long.class);
    return new AuthMember(id);
  }

  private void validateBearerToken(String bearerToken) {
    if (bearerToken == null) throw new CustomException(ErrorCode.NOT_EXIST_ACCESS_TOKEN);
    if(!bearerToken.startsWith(BEARER_TYPE)) throw new CustomException(ErrorCode.UNSUPPORTED_JWT_TOKEN);
  }

}
