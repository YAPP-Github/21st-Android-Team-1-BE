package yapp.buddycon.web.customcoupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.customcoupon.application.port.out.CustomCouponCommandPort;

@Repository
@RequiredArgsConstructor
public class CustomCouponCommandRepository implements CustomCouponCommandPort {

  private final CustomCouponJpaRepository customCouponJpaRepository;
}
