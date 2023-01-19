package yapp.buddycon.web.sharecoupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.sharecoupon.application.port.out.SharedCouponQueryPort;

@Repository
@RequiredArgsConstructor
public class SharedCouponQueryRepository implements SharedCouponQueryPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;
}
