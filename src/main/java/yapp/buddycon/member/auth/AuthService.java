package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.exception.CustomException;
import yapp.buddycon.exception.ErrorCode;
import yapp.buddycon.member.Member;
import yapp.buddycon.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberRepository memberRepository;
  private final KakaoOAuth kakaoOAuth;
  private final TokenProvider tokenProvider;
  private final TokenDecoder tokenDecoder;
  private final RedisTemplate<String, Object> redisTemplate;

  @Transactional
  public TokenResponse login(String accessToken) {
    OAuthMemberInfo oAuthMemberInfo = kakaoOAuth.getUserAttributes(accessToken);
    Member member = memberRepository.findMemberById(oAuthMemberInfo.id());
    if (member == null) {
      member = memberRepository.save(new Member(oAuthMemberInfo.id(), oAuthMemberInfo.nickname()));
    }
    return tokenProvider.createToken(member.getId());
  }

  @Transactional
  public TokenResponse reissue(ReissueRequest reissueRequest) {
    tokenDecoder.decode(reissueRequest.refreshToken()); // to validate refresh token
    Long id = tokenDecoder.decode(reissueRequest.accessToken()).getBody().get("memberId", Long.class);
    Object storedRefreshToken = redisTemplate.opsForValue().get("RT:" + id);
    if (storedRefreshToken == null) throw new CustomException(ErrorCode.LOGGED_OUT_MEMBER);
    if (!storedRefreshToken.equals(reissueRequest.refreshToken())) throw new CustomException(ErrorCode.TOKEN_MEMBER_INFO_IS_NOT_MATCH);

    return tokenProvider.createToken(id);
  }
}
