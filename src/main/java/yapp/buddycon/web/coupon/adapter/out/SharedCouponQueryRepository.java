package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponQueryPort;

@Repository
@RequiredArgsConstructor
public class SharedCouponQueryRepository implements SharedCouponQueryPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;
}
