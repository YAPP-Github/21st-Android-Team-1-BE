package yapp.buddycon.web.auth.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.auth.adapter.in.request.ReissueRequestDto;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberCommandPort;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberQueryPort;
import yapp.buddycon.web.member.domain.Member;
import yapp.buddycon.web.auth.application.port.in.OAuthMemberInfo;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;
import yapp.buddycon.web.auth.application.port.in.AuthUseCase;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

  private final KakaoOAuthMapper kakaoOAuthMapper;
  private final TokenProvider tokenProvider;
  private final TokenDecoder tokenDecoder;
  private final RedisTemplate<String, Object> redisTemplate;
  private final AuthToMemberQueryPort authToMemberQueryPort;
  private final AuthToMemberCommandPort authToMemberCommandPort;

  @Transactional
  public TokenResponseDto login(String accessToken) {
    OAuthMemberInfo oAuthMemberInfo = kakaoOAuthMapper.getUserAttributes(accessToken);
    Member member = authToMemberQueryPort.findMemberByClientId(oAuthMemberInfo.id());
    if (member == null) member = signup(oAuthMemberInfo);
    return tokenProvider.createToken(member.getId());
  }

  private Member signup(OAuthMemberInfo oAuthMemberInfo) {
    return authToMemberCommandPort.save(new Member(oAuthMemberInfo.id(), oAuthMemberInfo.nickname()));
  }

  @Transactional
  public TokenResponseDto reissue(ReissueRequestDto reissueRequestDto) {
    tokenDecoder.decode(reissueRequestDto.refreshToken()); // to validate refresh token
    Long id = tokenDecoder.decode(reissueRequestDto.accessToken()).getBody().get("memberId", Long.class);
    Object storedRefreshToken = redisTemplate.opsForValue().get("RT:" + id);
    if (storedRefreshToken == null) throw new CustomException(ErrorCode.LOGGED_OUT_MEMBER);
    if (!storedRefreshToken.equals(reissueRequestDto.refreshToken())) throw new CustomException(ErrorCode.TOKEN_MEMBER_INFO_IS_NOT_MATCH);

    return tokenProvider.createToken(id);
  }
}
