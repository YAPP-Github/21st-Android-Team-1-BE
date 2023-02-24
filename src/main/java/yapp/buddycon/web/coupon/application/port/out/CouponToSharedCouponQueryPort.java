package yapp.buddycon.web.coupon.application.port.out;

import yapp.buddycon.web.coupon.domain.SharedCoupon;

public interface CouponToSharedCouponQueryPort {

  SharedCoupon findSharedGifticonByBarcode(String barcode);
  SharedCoupon findSharedCustomCouponByBarcode(String barcode);

  SharedCoupon findById(long id);
}
