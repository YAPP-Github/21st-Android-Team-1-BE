package yapp.buddycon.web.member.auth.application.port.out;

import yapp.buddycon.web.member.domain.Member;

public interface AuthToMemberQueryPort {
  Member findMemberByClientId(Long clientId);
}
