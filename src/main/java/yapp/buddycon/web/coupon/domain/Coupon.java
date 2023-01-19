package yapp.buddycon.web.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;
import yapp.buddycon.web.member.domain.Member;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Coupon extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @Embedded
  private CouponInfo couponInfo;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private CouponState state;

  @Column(name = "coupon_type")
  @Enumerated(EnumType.STRING)
  private CouponType couponType;

}