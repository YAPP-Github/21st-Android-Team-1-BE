package yapp.buddycon.web.coupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.in.CouponUseCase;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;

@Service
@RequiredArgsConstructor
public class CouponService implements CouponUseCase {

  private final CouponCommandPort couponCommandPort;
  private final CouponQueryPort couponQueryPort;


  @Override
  public GifticonInfoResponseDto getGifticonInfo(Long memberId, Long couponId) {
    return couponQueryPort.findGifticonInfo(memberId, couponId);
  }

  @Override
  public CustomCouponInfoResponseDto getCustomCouponInfo(Long memberId, Long couponId) {
    return couponQueryPort.findCustomCouponInfo(memberId, couponId);
  }
}
