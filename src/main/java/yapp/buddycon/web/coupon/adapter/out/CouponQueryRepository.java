package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;

@Repository
@RequiredArgsConstructor
public class CouponQueryRepository implements CouponQueryPort {

  private final CouponJpaRepository couponJpaRepository;

  @Override
  public GifticonInfoResponseDto findGifticonInfo(Long memberId, Long couponId) {
    return couponJpaRepository.findGifticonByMemberIdAndIdAndCouponType(memberId, couponId);
  }

  @Override
  public CustomCouponInfoResponseDto findCustomCouponInfo(Long memberId, Long couponId) {
    return couponJpaRepository.findCustomCouponByMemberIdAndIdAndCouponType(memberId, couponId);
  }
}
