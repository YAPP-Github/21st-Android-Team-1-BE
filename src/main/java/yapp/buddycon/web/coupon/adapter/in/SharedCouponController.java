package yapp.buddycon.web.coupon.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.coupon.application.port.in.SharedCouponUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coupon/share")
public class SharedCouponController {

  private final SharedCouponUseCase sharedCouponUseCase;
}
