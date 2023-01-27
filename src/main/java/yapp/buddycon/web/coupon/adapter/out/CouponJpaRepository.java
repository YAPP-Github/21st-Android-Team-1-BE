package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.coupon.domain.CouponState;

import java.util.List;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.name, c.couponInfo.expireDate)
    from Coupon c
    where c.state = :state
    and c.couponType = 'REAL'
    and c.member.id = :memberId
  """)
  List<CouponsResponseDto> findSortedGifticonsAccordingToState(@Param("state") CouponState state, Long memberId, Pageable pageable);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.name, c.couponInfo.expireDate)
    from Coupon c
    where c.state = :state
    and c.couponType = 'CUSTOM'
    and c.member.id = :memberId
  """)
  List<CouponsResponseDto> findSortedCustomCouponsAccordingToState(@Param("state") CouponState state, Long memberId, Pageable pageable);

}
