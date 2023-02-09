package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.domain.SharedCoupon;

public interface SharedCouponCommandPort {
  SharedCoupon findByIdAndMemberId(Long couponId, Long memberId);
}
