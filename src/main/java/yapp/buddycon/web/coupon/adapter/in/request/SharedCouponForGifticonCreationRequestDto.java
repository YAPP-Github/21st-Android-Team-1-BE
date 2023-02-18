package yapp.buddycon.web.coupon.adapter.in.request;

import java.time.LocalDate;

public record SharedCouponForGifticonCreationRequestDto(
    Long couponId,
    String name,
    LocalDate expireDate,
    String storeName,
    String memo,
    Boolean shared
) {

}
