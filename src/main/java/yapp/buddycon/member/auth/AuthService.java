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
    OAuthMember oAuthMember = kakaoOAuth.getUserAttributes(accessToken);
    Member member = memberRepository.findMemberById(oAuthMember.id());
    if (member == null) {
      member = memberRepository.save(new Member(oAuthMember.id(), oAuthMember.nickname()));
    }
    return tokenProvider.createToken(String.valueOf(member.getId()));
  }
}
