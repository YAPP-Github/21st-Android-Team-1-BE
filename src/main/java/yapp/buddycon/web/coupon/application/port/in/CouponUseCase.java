package yapp.buddycon.web.coupon.application.port.in;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.request.GifticonCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.*;

import java.util.List;

import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;

public interface CouponUseCase {

  List<CouponsResponseDto> getSortedGifticons(boolean usable, Pageable pageable, AuthMember authMember);
  List<CouponsResponseDto> getSortedCustomCoupons(boolean usable, Pageable pageable, AuthMember authMember);

  GifticonInfoResponseDto getGifticonInfo(Long memberId, Long couponId);
  CustomCouponInfoResponseDto getCustomCouponInfo(Long memberId, Long couponId);

  DefaultResponseDto makeGifticon(GifticonCreationRequestDto gifticonCreationRequestDto, MultipartFile image, AuthMember authMember);

  DefaultResponseDto deleteCoupon(Long memberId, Long couponId);

  SharedGifticonInfoResponseDto getSharedGifticonInfoFromBarcode(String barcode);
  SharedCustomCouponResponseDto getSharedCustomCouponInfoFromBarcode(String barcode);

  DefaultResponseDto changeCouponState(Long memberId, Long couponId, String state);
}
