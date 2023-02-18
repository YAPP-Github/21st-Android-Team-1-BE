package yapp.buddycon.web.coupon.adapter.in.request;

import java.time.LocalDate;

public record SharedCouponForCustomCouponCreationRequestDto(
    String name,
    LocalDate expireDate,
    String storeName,
    String memo,
    Boolean shared
) {

}
