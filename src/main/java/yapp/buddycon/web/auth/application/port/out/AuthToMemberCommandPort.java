package yapp.buddycon.web.auth.application.port.out;

import yapp.buddycon.web.member.domain.Member;

public interface AuthToMemberCommandPort {

  Member save(Member member);
}
