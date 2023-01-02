package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.member.Member;
import yapp.buddycon.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberRepository memberRepository;
  private final KakaoOAuth kakaoOAuth;
  private final TokenProvider tokenProvider;

  @Transactional
  public TokenResponse login(String accessToken) {
    OAuthMemberInfo oAuthMemberInfo = kakaoOAuth.getUserAttributes(accessToken);
    Member member = memberRepository.findMemberById(oAuthMemberInfo.id());
    if (member == null) {
      member = memberRepository.save(new Member(oAuthMemberInfo.id(), oAuthMemberInfo.nickname()));
    }
    return tokenProvider.createToken(member.getId());
  }

//  @Transactional
//  public TokenResponse reissue(AuthMember authMember) {
//    return tokenProvider.createToken(authMember.id());
//  }
}
