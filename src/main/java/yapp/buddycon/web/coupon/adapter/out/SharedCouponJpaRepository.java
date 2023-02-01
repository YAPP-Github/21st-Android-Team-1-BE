package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

import java.util.Optional;

public interface SharedCouponJpaRepository extends JpaRepository<SharedCoupon, Long> {
  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.barcode, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.sharedCouponInfo.storeName, s.sharedCouponInfo.memo)
    from SharedCoupon s
    where s.sharedCouponInfo.barcode = :barcode
    and s.coupon.couponType = 'REAL'
    and s.shared = false
  """)
  Optional<SharedGifticonInfoResponseDto> findSharedGifticonByBarcode(String barcode);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.barcode, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.sharedCouponInfo.storeName, s.sharedCouponInfo.sentMember.name, s.sharedCouponInfo.memo)
    from SharedCoupon s
    where s.sharedCouponInfo.barcode = :barcode
    and s.coupon.couponType = 'CUSTOM'
    and s.shared = false
  """)
  Optional<SharedCustomCouponResponseDto> findSharedCustomCouponByBarcode(String barcode);
}
