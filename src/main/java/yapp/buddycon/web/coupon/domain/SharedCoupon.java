package yapp.buddycon.web.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.*;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForCustomCouponCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForGifticonCreationRequestDto;
import yapp.buddycon.web.member.domain.Member;

@Entity
@Builder
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

  @Column(name = "deleted")
  private boolean deleted;

  public void changeSharedCouponAndCouponSateToShared() {
    this.shared = true;
    coupon.changeToSharedState();
  }

  public void delete() {
    this.deleted = true;
  }

  public void save(){
    this.saved = true;
  }

  public static SharedCoupon createForGifticon(SharedCouponForGifticonCreationRequestDto dto,
      Member sentMember, String imageUrl, Coupon coupon) {
    return SharedCoupon.builder()
        .coupon(coupon)
        .sharedCouponInfo(SharedCouponInfo.valueOf(
            dto, imageUrl, coupon.getCouponInfo().getBarcode(), sentMember))
        .shared(false)
        .saved(false)
        .deleted(false)
        .build();
  }

  public static SharedCoupon createForCustomCoupon(SharedCouponForCustomCouponCreationRequestDto dto,
      Member sentMember, String imageUrl, String barcodeNumber) {
    return SharedCoupon.builder()
        .sharedCouponInfo(SharedCouponInfo.valueOf(
            dto, imageUrl, barcodeNumber, sentMember))
        .shared(false)
        .saved(false)
        .deleted(false)
        .build();
  }

}
