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

  @Column(name = "saved")
  private boolean saved;

  public void changeToSharedState() {
    this.shared = true;
  }

  @Column(name = "deleted")
  private boolean deleted;

  public void delete() {
    this.deleted = true;
  }

  public void save(){
    this.saved = true;
  }

}
