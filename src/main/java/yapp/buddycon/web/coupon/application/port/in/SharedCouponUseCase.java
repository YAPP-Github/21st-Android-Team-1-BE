package yapp.buddycon.web.coupon.application.port.in;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForGifticonCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;

import java.util.List;

public interface SharedCouponUseCase {
  List<SharedCouponsResponseDto> getSortedSharedCoupons(boolean unshared, Pageable pageable, Long memberId);

  DefaultResponseDto changeCustomCouponState(Long couponId, Long memberId);

  DefaultResponseDto deleteSharedCoupon(Long memberId, Long couponId);

  DefaultResponseDto makeSharedCouponForGifticon(SharedCouponForGifticonCreationRequestDto dto, MultipartFile image, Long memberId);

}
