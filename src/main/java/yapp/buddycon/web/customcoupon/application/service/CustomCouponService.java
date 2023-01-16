package yapp.buddycon.web.customcoupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.customcoupon.application.port.in.CustomCouponUseCase;
import yapp.buddycon.web.customcoupon.application.port.out.CustomCouponCommandPort;
import yapp.buddycon.web.customcoupon.application.port.out.CustomCouponQueryPort;

@Service
@RequiredArgsConstructor
public class CustomCouponService implements CustomCouponUseCase {

  private final CustomCouponCommandPort customCouponCommandPort;
  private final CustomCouponQueryPort customCouponQueryPort;


}
