package yapp.buddycon.web.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.application.port.out.CouponToMemberQueryPort;
import yapp.buddycon.web.member.application.port.out.MemberQueryPort;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberQueryPort;
import yapp.buddycon.web.member.domain.Member;

@Repository
@RequiredArgsConstructor
class MemberQueryRepository implements MemberQueryPort,
  AuthToMemberQueryPort, CouponToMemberQueryPort {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member findMemberByClientId(Long clientId) {
        return memberJpaRepository.findMemberByClientId(clientId);
    }

    @Override
    public Member findById(long id) {
        return memberJpaRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.INVALID_MEMBER_ID));
    }
}
