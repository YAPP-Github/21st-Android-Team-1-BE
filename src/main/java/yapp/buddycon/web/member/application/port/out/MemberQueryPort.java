package yapp.buddycon.web.member.application.port.out;


import yapp.buddycon.web.member.domain.Member;

public interface MemberQueryPort {
  Member findById(long id);
}
