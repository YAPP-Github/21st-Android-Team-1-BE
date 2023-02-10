package yapp.buddycon.web.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SharedCoupon extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "coupon_id")
  private Coupon coupon;

  @Embedded
  private SharedCouponInfo sharedCouponInfo;

  @Column(name = "shared")
  private boolean shared;

  public void changeToSharedState() {
    this.shared = true;
  }

}
