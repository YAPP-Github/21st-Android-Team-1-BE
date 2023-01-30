package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.Coupon;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.barcode, c.couponInfo.name, c.couponInfo.expireDate, c.couponInfo.storeName, c.couponInfo.memo, c.couponInfo.isMoneyCoupon, c.couponInfo.leftMoney)
    from Coupon c
    where c.member.id = :memberId
    and c.id = :id
    and c.couponType = 'REAL'
  """)
  GifticonInfoResponseDto findGifticonByMemberIdAndIdAndCouponType(Long memberId, Long id);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.barcode, c.couponInfo.name, c.couponInfo.expireDate, c.couponInfo.storeName, c.couponInfo.sentMemberName, c.couponInfo.memo)
    from Coupon c
    where c.member.id = :memberId
    and c.id = :id
    and c.couponType = 'CUSTOM'
  """)
  CustomCouponInfoResponseDto findCustomCouponByMemberIdAndIdAndCouponType(Long memberId, Long id);

}
