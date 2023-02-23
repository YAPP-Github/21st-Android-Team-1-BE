package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.coupon.domain.CouponState;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<Coupon> findByIdAndDeletedFalse(Long id);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.name, c.couponInfo.expireDate, c.createdAt)
    from Coupon c
    where c.state = :state
    and c.couponType = 'REAL'
    and c.member.id = :memberId
    and c.deleted = false
  """)
  List<CouponsResponseDto> findSortedGifticonsAccordingToState(@Param("state") CouponState state, Long memberId, Pageable pageable);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.name, c.couponInfo.expireDate, c.createdAt)
    from Coupon c
    where c.state = :state
    and c.couponType = 'CUSTOM'
    and c.member.id = :memberId
    and c.deleted = false
  """)
  List<CouponsResponseDto> findSortedCustomCouponsAccordingToState(@Param("state") CouponState state, Long memberId, Pageable pageable);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.barcode, c.couponInfo.name, c.couponInfo.expireDate, c.couponInfo.storeName, c.couponInfo.sentMemberName, c.couponInfo.memo, c.couponInfo.isMoneyCoupon, c.couponInfo.leftMoney)
    from Coupon c
    where c.member.id = :memberId
    and c.id = :id
    and c.couponType = 'REAL'
    and c.deleted = false
  """)
  GifticonInfoResponseDto findGifticonByMemberIdAndIdAndCouponType(Long memberId, Long id);

  @Query(value = """
    select new yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto(c.id, c.couponInfo.imageUrl, c.couponInfo.barcode, c.couponInfo.name, c.couponInfo.expireDate, c.couponInfo.storeName, c.couponInfo.sentMemberName, c.couponInfo.memo)
    from Coupon c
    where c.member.id = :memberId
    and c.id = :id
    and c.couponType = 'CUSTOM'
    and c.deleted = false
  """)
  CustomCouponInfoResponseDto findCustomCouponByMemberIdAndIdAndCouponType(Long memberId, Long id);

  @Modifying
  @Query(value = """
    update Coupon c
    set c.state = 'USED'
    where c.member.id = :memberId
    and c.id = :couponId
    and c.deleted = false
  """
  )
  void changeStateUsableToUsed(Long memberId, Long couponId);

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query(value = """
    select c
    from Coupon c
    where c.member.id = :memberId
    and c.id = :couponId
    and c.state = 'USED'
    and c.couponInfo.expireDate > :today
    and c.deleted = false
  """)
  Optional<Coupon> findCouponInUsedStateAndNotExpiredWithLock(Long memberId, Long couponId, LocalDate today);

  @Modifying
  @Query(value = """
    update Coupon c
    set c.state = 'USABLE'
    where c.member.id = :memberId
    and c.id = :couponId
    and c.deleted = false
  """
  )
  void changeStateUsedToUsable(Long memberId, Long couponId);
}
