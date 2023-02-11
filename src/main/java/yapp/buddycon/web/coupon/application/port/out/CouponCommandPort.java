package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.domain.Coupon;

public interface CouponCommandPort {

  void createCoupon(Coupon coupon);

  void save(Long memberId, Coupon coupon);

  void changeStateUsableToUsed(Long memberId, Long couponId);
  void changeStateUsedToUsable(Long memberId, Long couponId);

}
