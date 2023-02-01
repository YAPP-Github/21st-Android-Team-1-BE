package yapp.buddycon.web.coupon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.out.CouponToSharedCouponQueryPort;
import yapp.buddycon.web.coupon.application.port.out.SharedCouponQueryPort;

@Repository
@RequiredArgsConstructor
public class SharedCouponQueryRepository implements SharedCouponQueryPort, CouponToSharedCouponQueryPort {

  private final SharedCouponJpaRepository sharedCouponJpaRepository;

  @Override
  public SharedGifticonInfoResponseDto findSharedGifticonByBarcode(String barcode) {
    return sharedCouponJpaRepository.findSharedGifticonByBarcode(barcode).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_BARCODE_NUMBER));
  }

  @Override
  public SharedCustomCouponResponseDto findSharedCustomCouponByBarcode(String barcode) {
    return sharedCouponJpaRepository.findSharedCustomCouponByBarcode(barcode).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_BARCODE_NUMBER));
  }
}
