package yapp.buddycon.web.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findMemberById(Long id);
  boolean existsByClientId(Long clientId);
}
