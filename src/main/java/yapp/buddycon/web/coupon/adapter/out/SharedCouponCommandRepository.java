package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponCommandPort;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

@Repository
@RequiredArgsConstructor
public class SharedCouponCommandRepository implements SharedCouponCommandPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;

  @Override
  public SharedCoupon findByIdAndMemberId(Long couponId, Long memberId) {
    return sharedCouponJpaRepository.findByIdAndMemberId(memberId, couponId).orElseThrow(() -> new CustomException(ErrorCode.INVALID_COUPON_ID));
  }
}
