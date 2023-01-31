package yapp.buddycon.web.coupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.in.CouponUseCase;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;
import yapp.buddycon.web.coupon.domain.Coupon;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService implements CouponUseCase {

  private final CouponCommandPort couponCommandPort;
  private final CouponQueryPort couponQueryPort;

  @Override
  public List<CouponsResponseDto> getSortedGifticons(boolean usable, Pageable pageable, AuthMember authMember) {
    Sort sort = SortPageableValidation.validateSortProperty(pageable.getSort().toString());
    PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
    if(usable) return couponQueryPort.findUsableGifticonsSortedBy(pageRequest, authMember.id());
    return couponQueryPort.findUsedGifticonsSortedBy(pageRequest, authMember.id());
  }

  @Override
  public List<CouponsResponseDto> getSortedCustomCoupons(boolean usable, Pageable pageable, AuthMember authMember) {
    Sort sort = SortPageableValidation.validateSortProperty(pageable.getSort().toString());
    PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
    if(usable) return couponQueryPort.findUsableCustomCouponsSortedBy(pageRequest, authMember.id());
    return couponQueryPort.findUsedCustomCouponsSortedBy(pageRequest, authMember.id());
  }

  @Override
  public GifticonInfoResponseDto getGifticonInfo(Long memberId, Long couponId) {
    return couponQueryPort.findGifticonInfo(memberId, couponId);
  }

  @Override
  public CustomCouponInfoResponseDto getCustomCouponInfo(Long memberId, Long couponId) {
    return couponQueryPort.findCustomCouponInfo(memberId, couponId);
  }

  @Override
  @Transactional
  public DefaultResponseDto deleteCoupon(Long memberId, Long couponId) {
    Coupon coupon = couponQueryPort.findById(couponId);
    couponCommandPort.deleteCoupon(memberId, coupon.getId());
    return new DefaultResponseDto(true, "쿠폰을 삭제하였습니다.");
  }
}
