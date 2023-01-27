package yapp.buddycon.web.coupon.application.port.in;

import org.springframework.data.domain.Pageable;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;

import java.util.List;

public interface CouponUseCase {

  List<CouponsResponseDto> getSortedGifticons(boolean usable, Pageable pageable, AuthMember authMember);

  List<CouponsResponseDto> getSortedCustomCoupons(boolean usable, Pageable pageable, AuthMember authMember);

}
