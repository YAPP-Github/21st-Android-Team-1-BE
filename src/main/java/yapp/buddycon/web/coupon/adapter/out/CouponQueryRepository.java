package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.coupon.domain.CouponState;

import java.time.LocalDate;
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


  @Override
  public GifticonInfoResponseDto findGifticonInfo(Long memberId, Long couponId) {
    return couponJpaRepository.findGifticonByMemberIdAndIdAndCouponType(memberId, couponId);
  }

  @Override
  public CustomCouponInfoResponseDto findCustomCouponInfo(Long memberId, Long couponId) {
    return couponJpaRepository.findCustomCouponByMemberIdAndIdAndCouponType(memberId, couponId);
  }

  @Override
  public Coupon findById(Long id) {
    return couponJpaRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.INVALID_COUPON_ID));
  }

  @Override
  public Coupon findCouponUsed(Long memberId, Long couponId, LocalDate date) {
    return couponJpaRepository.findCouponInUsedStateAndNotExpiredWithLock(memberId, couponId, date).orElseThrow(() -> new CustomException(ErrorCode.INVALID_STATE_CHANGE_REQUEST));
  }
}
