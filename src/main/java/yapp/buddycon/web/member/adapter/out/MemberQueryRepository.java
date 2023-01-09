package yapp.buddycon.web.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.member.application.port.out.MemberQueryPort;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberQueryPort;
import yapp.buddycon.web.member.domain.Member;

@Repository
@RequiredArgsConstructor
class MemberQueryRepository implements MemberQueryPort,
  AuthToMemberQueryPort {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member findMemberByClientId(Long clientId) {
        return memberJpaRepository.findMemberByClientId(clientId);
    }
}
