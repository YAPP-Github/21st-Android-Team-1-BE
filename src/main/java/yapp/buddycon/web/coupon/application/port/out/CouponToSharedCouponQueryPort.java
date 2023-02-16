package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

public interface CouponToSharedCouponQueryPort {

  SharedGifticonInfoResponseDto findSharedGifticonByBarcode(String barcode);
  SharedCustomCouponResponseDto findSharedCustomCouponByBarcode(String barcode);

  SharedCoupon findById(long id);
}
