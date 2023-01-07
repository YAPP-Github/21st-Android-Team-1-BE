package yapp.buddycon.web.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;

@Component
@RequiredArgsConstructor
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

  @Value("${security.jwt.token.bearer-type}")
  private String BEARER_TYPE;

  private final AuthMemberProvider authMemberProvider;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType() == AuthMember.class;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String bearerToken = webRequest.getHeader("Authorization");
    validateBearerToken(bearerToken);
    return authMemberProvider.getAuthMember(bearerToken.split(" ")[1].trim());
  }

  private void validateBearerToken(String bearerToken) {
    if (bearerToken == null) throw new CustomException(ErrorCode.NOT_EXIST_ACCESS_TOKEN);
    if(!bearerToken.startsWith(BEARER_TYPE)) throw new CustomException(ErrorCode.UNSUPPORTED_JWT_TOKEN);
  }
}
