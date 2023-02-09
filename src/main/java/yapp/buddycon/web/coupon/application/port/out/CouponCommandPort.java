package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.domain.Coupon;

public interface CouponCommandPort {

  void createCoupon(Coupon coupon);

  void deleteCoupon(Long memberId, Long couponId);

  void save(Long memberId, Coupon coupon);

}
