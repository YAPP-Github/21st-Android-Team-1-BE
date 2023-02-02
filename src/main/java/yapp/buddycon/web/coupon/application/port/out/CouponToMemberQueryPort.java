package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.member.domain.Member;

public interface CouponToMemberQueryPort {

  Member findById(long id);

}
