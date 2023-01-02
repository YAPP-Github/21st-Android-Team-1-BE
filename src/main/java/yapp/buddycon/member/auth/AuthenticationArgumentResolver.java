package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import yapp.buddycon.exception.CustomException;
import yapp.buddycon.exception.ErrorCode;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

  private final AuthMemberProvider authMemberProvider;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType() == AuthMember.class;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String token = webRequest.getHeader("Authorization");
    if (token == null) throw new CustomException(ErrorCode.NOT_EXIST_ACCESS_TOKEN);
    authMemberProvider.getAuthMember(token.substring(7));
    return null;
  }
}
