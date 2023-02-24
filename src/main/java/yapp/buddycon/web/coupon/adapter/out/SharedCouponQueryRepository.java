package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;
import yapp.buddycon.web.coupon.application.port.out.CouponToSharedCouponQueryPort;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponQueryPort;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SharedCouponQueryRepository implements SharedCouponQueryPort, CouponToSharedCouponQueryPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;

  @Override
  public SharedCoupon findSharedGifticonByBarcode(String barcode) {
    return sharedCouponJpaRepository.findSharedGifticonByBarcode(barcode).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_BARCODE_NUMBER));
  }

  @Override
  public SharedCoupon findSharedCustomCouponByBarcode(String barcode) {
    return sharedCouponJpaRepository.findSharedCustomCouponByBarcode(barcode).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_BARCODE_NUMBER));
  }

  @Override
  public SharedCoupon findById(long id) {
    return sharedCouponJpaRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.INVALID_COUPON_ID));
  }

  @Override
  public List<SharedCouponsResponseDto> findUnsharedCustomCouponsSortedBy(Long memberId, Pageable pageable) {
    return sharedCouponJpaRepository.findUnsharedCustomCouponsSortedBy(memberId, pageable);
  }

  @Override
  public List<SharedCouponsResponseDto> findCustomCouponsSortedBy(Long memberId, Pageable pageable) {
    return sharedCouponJpaRepository.findCustomCouponsSortedBy(memberId, pageable);
  }

  @Override
  public SharedCoupon findByIdAndMemberId(Long couponId, Long memberId) {
    return sharedCouponJpaRepository.findByIdAndMemberId(couponId, memberId).orElseThrow(() -> new CustomException(ErrorCode.INVALID_COUPON_ID));
  }
}
