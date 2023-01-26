package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;
import yapp.buddycon.web.coupon.domain.CouponState;

@Repository
@RequiredArgsConstructor
public class CouponQueryRepository implements CouponQueryPort {

  private final CouponJpaRepository couponJpaRepository;

}
