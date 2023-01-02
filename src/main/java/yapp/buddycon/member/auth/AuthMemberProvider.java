package yapp.buddycon.member.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthMemberProvider {

  private final TokenDecoder decoder;

  public AuthMember getAuthMember(String accessToken) {
    return new AuthMember(Long.parseLong(decoder.decode(accessToken)));
  }
}
