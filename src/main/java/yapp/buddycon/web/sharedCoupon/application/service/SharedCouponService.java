package yapp.buddycon.web.sharedCoupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.sharedCoupon.application.port.in.SharedCouponUseCase;
import yapp.buddycon.web.sharedCoupon.application.port.out.SharedCouponCommandPort;
import yapp.buddycon.web.sharedCoupon.application.port.out.SharedCouponQueryPort;

@Service
@RequiredArgsConstructor
public class SharedCouponService implements SharedCouponUseCase {

  private final SharedCouponCommandPort sharedCouponCommandPort;
  private final SharedCouponQueryPort sharedCouponQueryPort;
}
