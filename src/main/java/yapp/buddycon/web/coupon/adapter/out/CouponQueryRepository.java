package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;
import yapp.buddycon.web.coupon.domain.CouponState;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CouponQueryRepository implements CouponQueryPort {

  private final CouponJpaRepository couponJpaRepository;

  @Override
  public List<CouponsResponseDto> findUsableGifticonsSortedBy(Pageable pageable, Long memberId) {
    return couponJpaRepository.findSortedGifticonsAccordingToState(CouponState.USABLE, memberId, pageable);
  }

  @Override
  public List<CouponsResponseDto> findUsedGifticonsSortedBy(Pageable pageable, Long memberId) {
    return couponJpaRepository.findSortedGifticonsAccordingToState(CouponState.USED, memberId, pageable);
  }

  @Override
  public List<CouponsResponseDto> findUsableCustomCouponsSortedBy(Pageable pageable, Long memberId) {
    return couponJpaRepository.findSortedCustomCouponsAccordingToState(CouponState.USABLE, memberId, pageable);
  }

  @Override
  public List<CouponsResponseDto> findUsedCustomCouponsSortedBy(Pageable pageable, Long memberId) {
    return couponJpaRepository.findSortedCustomCouponsAccordingToState(CouponState.USED, memberId, pageable);
  }


}
