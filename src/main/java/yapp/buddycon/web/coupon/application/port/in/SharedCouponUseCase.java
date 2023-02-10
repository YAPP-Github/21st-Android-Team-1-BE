package yapp.buddycon.web.coupon.application.port.in;

import org.springframework.data.domain.Pageable;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;

import java.util.List;

public interface SharedCouponUseCase {
  List<SharedCouponsResponseDto> getSortedSharedCoupons(boolean unshared, Pageable pageable, Long memberId);

  DefaultResponseDto changeCustomCouponState(Long couponId, Long memberId);
}
