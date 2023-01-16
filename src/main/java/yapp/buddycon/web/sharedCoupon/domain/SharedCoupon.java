package yapp.buddycon.web.sharedCoupon.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SharedCoupon extends BaseEntity {

  @Column(name = "coupon_id", nullable = false)
  private Long couponId;

  @Column(name = "sent_member_id", nullable = false)
  private Long sentMemberId;

  @Column(name = "attachment_id", nullable = false)
  private Long attachmentId;

  @Embedded
  private SharedCouponInfo sharedCouponInfo;

}
