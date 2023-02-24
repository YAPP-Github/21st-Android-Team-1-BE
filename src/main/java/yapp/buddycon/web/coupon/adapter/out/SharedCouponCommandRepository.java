package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponCommandPort;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

@Repository
@RequiredArgsConstructor
public class SharedCouponCommandRepository implements SharedCouponCommandPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;

  @Override
  public void save(SharedCoupon sharedCoupon) {
    sharedCouponJpaRepository.save(sharedCoupon);
  }
}
