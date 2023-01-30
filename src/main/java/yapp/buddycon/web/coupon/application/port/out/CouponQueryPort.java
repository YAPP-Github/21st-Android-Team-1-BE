package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;

public interface CouponQueryPort {

  GifticonInfoResponseDto findGifticonInfo(Long memberId, Long couponId);
  CustomCouponInfoResponseDto findCustomCouponInfo(Long memberId, Long couponId);
}
