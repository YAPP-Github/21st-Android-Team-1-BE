package yapp.buddycon.web.coupon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForCustomCouponCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForGifticonCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;
import yapp.buddycon.web.coupon.application.port.in.SharedCouponUseCase;
import yapp.buddycon.web.coupon.application.port.out.CouponQueryPort;
import yapp.buddycon.web.coupon.application.port.out.CouponToAwsS3FileProviderPort;
import yapp.buddycon.web.coupon.application.port.out.CouponToMemberQueryPort;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponCommandPort;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponQueryPort;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

import java.util.List;
import yapp.buddycon.web.member.domain.Member;

@Service
@RequiredArgsConstructor
public class SharedCouponService implements SharedCouponUseCase {

  private final SharedCouponCommandPort sharedCouponCommandPort;
  private final SharedCouponQueryPort sharedCouponQueryPort;
  private final CouponToAwsS3FileProviderPort couponToAwsS3FileProviderPort;
  private final CouponToMemberQueryPort couponToMemberQueryPort;
  private final CouponQueryPort couponQueryPort;

  @Override
  public List<SharedCouponsResponseDto> getSortedSharedCoupons(boolean unshared, Pageable pageable, Long memberId) {
    Sort sort = SortPageableValidation.validateSortProperty(pageable.getSort().toString(), true);
    PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
    if(unshared) return sharedCouponQueryPort.findUnsharedCustomCouponsSortedBy(memberId, pageRequest);
    else return sharedCouponQueryPort.findCustomCouponsSortedBy(memberId, pageRequest);
  }

  @Override
  @Transactional
  public DefaultResponseDto changeCustomCouponState(Long couponId, Long memberId) {
    SharedCoupon sharedCoupon = sharedCouponQueryPort.findByIdAndMemberId(couponId, memberId);
    sharedCoupon.changeToSharedState();
    return new DefaultResponseDto(true, "공유완료 상태로 변경되었습니다");
  }

  @Override
  @Transactional
  public DefaultResponseDto deleteSharedCoupon(Long memberId, Long couponId) {
    SharedCoupon sharedCoupon = sharedCouponQueryPort.findByIdAndMemberId(couponId, memberId);
    sharedCoupon.delete();
    return new DefaultResponseDto(true, "쿠폰을 삭제하였습니다.");
  }

  @Override
  @Transactional
  public DefaultResponseDto makeSharedCouponForGifticon(SharedCouponForGifticonCreationRequestDto dto, MultipartFile image, Long memberId) {
    Member sentMember = couponToMemberQueryPort.findById(memberId);
    String imageUrl = couponToAwsS3FileProviderPort.upload(image);

    Coupon coupon = couponQueryPort.findById(dto.couponId());

    SharedCoupon.createForGifticon(dto, sentMember, imageUrl, coupon);
    return new DefaultResponseDto(true, "만든 쿠폰(재활용)이 생성되었습니다.");
  }

  @Override
  @Transactional
  public DefaultResponseDto makeSharedCouponForCustomCoupon(SharedCouponForCustomCouponCreationRequestDto dto, MultipartFile image, Long memberId) {
    Member sentMember = couponToMemberQueryPort.findById(memberId);
    String imageUrl = couponToAwsS3FileProviderPort.upload(image);

    SharedCoupon.createForCustomCoupon(dto, sentMember, imageUrl);
    return new DefaultResponseDto(true, "만든 쿠폰(제작)이 생성되었습니다.");
  }

}
