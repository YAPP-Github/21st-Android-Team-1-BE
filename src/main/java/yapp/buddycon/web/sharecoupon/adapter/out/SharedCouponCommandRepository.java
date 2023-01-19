package yapp.buddycon.web.sharecoupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.sharecoupon.application.port.out.SharedCouponCommandPort;

@Repository
@RequiredArgsConstructor
public class SharedCouponCommandRepository implements SharedCouponCommandPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;
}
