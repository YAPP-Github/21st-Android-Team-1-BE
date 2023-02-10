package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;
import yapp.buddycon.web.coupon.domain.Coupon;

@Repository
@RequiredArgsConstructor
public class CouponCommandRepository implements CouponCommandPort {

  private final CouponJpaRepository couponJpaRepository;

  @Override
  public void createCoupon(Coupon coupon) {
    couponJpaRepository.save(coupon);
  }

  @Override
  public void deleteCoupon(Long memberId, Long couponId) {
    couponJpaRepository.deleteByIdAndMemberId(couponId, memberId);
  }

  @Override
  public void save(Long memberId, Coupon coupon) {
    if (!coupon.checkMemberPermission(memberId)) {
      throw new CustomException(ErrorCode.CANT_ACCESS_COUPON);
    }
    couponJpaRepository.save(coupon);
  }

  @Override
  public void changeStateUsableToUsed(Long memberId, Long couponId) {
    couponJpaRepository.changeStateUsableToUsed(memberId, couponId);
  }

  @Override
  public void changeStateUsedToUsable(Long memberId, Long couponId) {
    couponJpaRepository.changeStateUsedToUsable(memberId, couponId);
  }
}
