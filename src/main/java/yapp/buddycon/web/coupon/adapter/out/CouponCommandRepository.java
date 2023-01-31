package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;

@Repository
@RequiredArgsConstructor
public class CouponCommandRepository implements CouponCommandPort {

  private final CouponJpaRepository couponJpaRepository;


  @Override
  public void deleteCoupon(Long memberId, Long couponId) {
    couponJpaRepository.deleteByIdAndMemberId(couponId, memberId);
  }
}
