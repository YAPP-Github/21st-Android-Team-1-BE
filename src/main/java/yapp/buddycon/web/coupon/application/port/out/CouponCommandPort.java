package yapp.buddycon.web.coupon.application.port.out;

public interface CouponCommandPort {

  void deleteCoupon(Long memberId, Long couponId);

}
