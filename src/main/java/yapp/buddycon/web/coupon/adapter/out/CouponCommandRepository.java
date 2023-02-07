package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;
import yapp.buddycon.web.coupon.domain.Coupon;

@Repository
@RequiredArgsConstructor
public class CouponCommandRepository implements CouponCommandPort {

  private final CouponJpaRepository couponJpaRepository;

  @Override
  public void createCoupon(Coupon coupon) {
    couponJpaRepository.save(coupon);
  }

  @Override
  public void deleteCoupon(Long memberId, Long couponId) {
    couponJpaRepository.deleteByIdAndMemberId(couponId, memberId);
  }
}
