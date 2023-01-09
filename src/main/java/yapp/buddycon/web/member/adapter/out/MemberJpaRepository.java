package yapp.buddycon.web.member.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.member.domain.Member;

interface MemberJpaRepository extends JpaRepository<Member, Long> {
  Member findMemberByClientId(Long clientId);
}