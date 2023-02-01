package yapp.buddycon.web.coupon.application.port.out;

import org.springframework.data.domain.Pageable;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.Coupon;

import java.util.List;

public interface CouponQueryPort {

  List<CouponsResponseDto> findUsableGifticonsSortedBy(Pageable pageable, Long memberId);
  List<CouponsResponseDto> findUsedGifticonsSortedBy(Pageable pageable, Long memberId);

  List<CouponsResponseDto> findUsableCustomCouponsSortedBy(Pageable pageable, Long memberId);
  List<CouponsResponseDto> findUsedCustomCouponsSortedBy(Pageable pageable, Long memberId);


  GifticonInfoResponseDto findGifticonInfo(Long memberId, Long couponId);
  CustomCouponInfoResponseDto findCustomCouponInfo(Long memberId, Long couponId);

  Coupon findById(Long id);
}
