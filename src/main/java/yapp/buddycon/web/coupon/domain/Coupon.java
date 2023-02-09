package yapp.buddycon.web.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;
import yapp.buddycon.web.coupon.adapter.in.request.GifticonInfoEditRequestDto;
import yapp.buddycon.web.member.domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupon extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @Embedded
  private CouponInfo couponInfo;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private CouponState state;

  @Column(name = "coupon_type")
  @Enumerated(EnumType.STRING)
  private CouponType couponType;

  public static Coupon create(Member member, CouponInfo couponInfo, CouponType couponType) {
    return Coupon.builder()
        .member(member)
        .couponInfo(couponInfo)
        .state(CouponState.USABLE)
        .couponType(couponType)
        .build();
  }

  public void updateCouponInfo(GifticonInfoEditRequestDto dto) {
    this.couponInfo.update(dto);
  }

}
