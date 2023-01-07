package yapp.buddycon.web.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findMemberByClientId(Long clientId);
  boolean existsByClientId(Long clientId);
}
