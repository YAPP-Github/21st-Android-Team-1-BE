package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

import java.util.List;
import java.util.Optional;

public interface SharedCouponJpaRepository extends JpaRepository<SharedCoupon, Long> {
  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedGifticonInfoResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.barcode, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.sharedCouponInfo.storeName, s.sharedCouponInfo.memo)
    from SharedCoupon s
    where s.sharedCouponInfo.barcode = :barcode
    and s.coupon.couponType = 'REAL'
    and s.shared = true
    and s.saved = false
  """)
  Optional<SharedGifticonInfoResponseDto> findSharedGifticonByBarcode(String barcode);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedCustomCouponResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.barcode, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.sharedCouponInfo.storeName, s.sharedCouponInfo.sentMember.name, s.sharedCouponInfo.memo)
    from SharedCoupon s
    where s.sharedCouponInfo.barcode = :barcode
    and s.coupon.couponType = 'CUSTOM'
    and s.shared = true
    and s.saved = false
  """)
  Optional<SharedCustomCouponResponseDto> findSharedCustomCouponByBarcode(String barcode);


  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.createdAt, s.shared)
    from SharedCoupon s
    where s.sharedCouponInfo.sentMember.id = :memberId
    order by s.shared
  """)
  List<SharedCouponsResponseDto> findUnsharedCustomCouponsSortedBy(Long memberId, Pageable pageable);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.SharedCouponsResponseDto(s.id, s.sharedCouponInfo.imageUrl, s.sharedCouponInfo.name, s.sharedCouponInfo.expireDate, s.createdAt, s.shared)
    from SharedCoupon s
    where s.sharedCouponInfo.sentMember.id = :memberId
  """)
  List<SharedCouponsResponseDto> findCustomCouponsSortedBy(Long memberId, Pageable pageable);

  @Query(value = """
    select s
    from SharedCoupon s
    where s.sharedCouponInfo.sentMember.id = :memberId
    and s.coupon.id = :id
  """)
  Optional<SharedCoupon> findByIdAndMemberId(Long id, Long memberId);
}
