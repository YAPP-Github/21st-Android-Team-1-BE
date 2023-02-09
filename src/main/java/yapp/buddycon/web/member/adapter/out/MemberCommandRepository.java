package yapp.buddycon.web.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.auth.application.port.out.AuthToNotificationSettingCommandPort;
import yapp.buddycon.web.member.application.port.out.MemberCommandPort;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberCommandPort;
import yapp.buddycon.web.member.domain.Member;
import yapp.buddycon.web.member.domain.NotificationSetting;

@Repository
@RequiredArgsConstructor
class MemberCommandRepository implements MemberCommandPort,
  AuthToMemberCommandPort {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }
}
