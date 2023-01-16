package yapp.buddycon.web.customcoupon.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;
import yapp.buddycon.web.attachment.domain.Attachment;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomCoupon extends BaseEntity {

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @OneToOne
  @JoinColumn(name = "attachment_id")
  private Attachment attachment;

  @Embedded
  private CustomCouponInfo customCouponInfo;

  @Column(name = "custom_coupon_state")
  @Enumerated(EnumType.STRING)
  private CustomCouponState CustomCouponState;

}
