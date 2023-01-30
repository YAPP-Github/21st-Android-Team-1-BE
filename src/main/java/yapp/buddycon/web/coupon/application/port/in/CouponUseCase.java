package yapp.buddycon.web.coupon.application.port.in;

import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;

public interface CouponUseCase {

  GifticonInfoResponseDto getGifticonInfo(Long memberId, Long couponId);

  CustomCouponInfoResponseDto getCustomCouponInfo(Long memberId, Long couponId);
}
