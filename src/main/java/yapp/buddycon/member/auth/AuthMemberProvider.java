package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthMemberProvider {

  private final TokenDecoder decoder;

  public AuthMember getAuthMember(String accessToken) {
    Long id = decoder.decode(accessToken).getBody().get("memberId", Long.class);
    return new AuthMember(id);
  }
}
