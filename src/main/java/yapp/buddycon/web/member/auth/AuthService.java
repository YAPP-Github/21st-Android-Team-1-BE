package yapp.buddycon.web.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.web.member.Member;
import yapp.buddycon.web.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberRepository memberRepository;
  private final KakaoOAuth kakaoOAuth;
  private final TokenProvider tokenProvider;
  private final TokenDecoder tokenDecoder;
//  private final RedisTemplate<String, Object> redisTemplate;

  @Transactional
  public TokenResponseDto login(String accessToken) {
    OAuthMemberInfo oAuthMemberInfo = kakaoOAuth.getUserAttributes(accessToken);
    Member member = memberRepository.findMemberById(oAuthMemberInfo.id());
    if (member == null) {
      member = memberRepository.save(new Member(oAuthMemberInfo.id(), oAuthMemberInfo.nickname()));
    }
    return tokenProvider.createToken(member.getId());
  }

//  @Override
//  public Member signup(OAuthMemberInfo oAuthMemberInfo) {
//    return memberRepository.save(new Member(oAuthMemberInfo.id(), oAuthMemberInfo.nickname()));
//  }

//  @Transactional
//  public TokenResponseDto reissue(ReissueRequestDto reissueRequestDto) {
//    tokenDecoder.decode(reissueRequestDto.refreshToken()); // to validate refresh token
//    Long id = tokenDecoder.decode(reissueRequestDto.accessToken()).getBody().get("memberId", Long.class);
//    Object storedRefreshToken = redisTemplate.opsForValue().get("RT:" + id);
//    if (storedRefreshToken == null) throw new CustomException(ErrorCode.LOGGED_OUT_MEMBER);
//    if (!storedRefreshToken.equals(reissueRequestDto.refreshToken())) throw new CustomException(ErrorCode.TOKEN_MEMBER_INFO_IS_NOT_MATCH);
//
//    return tokenProvider.createToken(id);
//  }
}
