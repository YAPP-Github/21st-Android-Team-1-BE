package yapp.buddycon.web.customcoupon.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.customcoupon.application.port.in.CustomCouponUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coupon/customcoupon")
public class CustomCouponController {

  private final CustomCouponUseCase customCouponUseCase;
}
