package yapp.buddycon.web.sharecoupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.sharecoupon.application.port.in.SharedCouponUseCase;
import yapp.buddycon.web.sharecoupon.application.port.out.SharedCouponCommandPort;
import yapp.buddycon.web.sharecoupon.application.port.out.SharedCouponQueryPort;

@Service
@RequiredArgsConstructor
public class SharedCouponService implements SharedCouponUseCase {

  private final SharedCouponCommandPort sharedCouponCommandPort;
  private final SharedCouponQueryPort sharedCouponQueryPort;
}
