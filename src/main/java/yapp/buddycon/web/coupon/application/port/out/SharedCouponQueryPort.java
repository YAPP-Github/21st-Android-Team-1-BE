package yapp.buddycon.web.coupon.application.port.out;

import org.springframework.data.domain.Pageable;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

import java.util.List;

public interface SharedCouponQueryPort {

  List<SharedCouponsResponseDto> findUnsharedCustomCouponsSortedBy(Long memberId, Pageable pageable);
  List<SharedCouponsResponseDto> findCustomCouponsSortedBy(Long memberId, Pageable pageable);

  SharedCoupon findByIdAndMemberId(Long couponId, Long memberId);
}
