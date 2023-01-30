package yapp.buddycon.web.coupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.application.port.in.CouponUseCase;
import yapp.buddycon.web.coupon.application.port.out.CouponCommandPort;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;

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

  /*
  유효기간순 -> expireDate ASC
  등록순 -> createdAt ASC
  이름순 -> name ASC
  page=3&size=10&sort=couponInfo.expireDate,DESC
  */

}
