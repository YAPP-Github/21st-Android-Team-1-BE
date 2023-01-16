package yapp.buddycon.web.customcoupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.customcoupon.application.port.out.CustomCouponQueryPort;

@Repository
@RequiredArgsConstructor
public class CustomCouponQueryRepository implements CustomCouponQueryPort {

  private final CustomCouponJpaRepository customCouponJpaRepository;

}
