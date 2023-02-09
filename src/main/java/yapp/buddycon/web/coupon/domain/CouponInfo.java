package yapp.buddycon.web.coupon.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yapp.buddycon.web.coupon.adapter.in.request.CustomCouponCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.CustomCouponInfoEditRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.GifticonCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.GifticonInfoEditRequestDto;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponInfo {

  @Column(name = "barcode", nullable = false)
  private String barcode;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(name = "name", nullable = false, length = 16)
  private String name;

  @Column(name = "memo", length = 50)
  private String memo;

  @Column(name = "store_name", length = 16)
  private String storeName;

  @Column(name = "sent_member_name", length = 50)
  private String sentMemberName;

  @Column(name = "is_money_coupon")
  private boolean isMoneyCoupon;

  @Column(name = "left_money")
  private Integer leftMoney;

  @Column(name = "expire_date")
  private LocalDate expireDate;

  public static CouponInfo valueOf(GifticonCreationRequestDto dto, String imageUrl) {
    return CouponInfo.builder()
        .barcode(dto.barcode())
        .imageUrl(imageUrl)
        .name(dto.name())
        .memo(dto.memo())
        .storeName(dto.storeName())
        .isMoneyCoupon(dto.isMoneyCoupon())
        .leftMoney(dto.leftMoney())
        .expireDate(dto.expireDate())
        .build();
  }

  public static CouponInfo valueOf(CustomCouponCreationRequestDto dto, String imageUrl) {
    return CouponInfo.builder()
        .barcode(dto.barcode())
        .imageUrl(imageUrl)
        .name(dto.name())
        .memo(dto.memo())
        .storeName(dto.storeName())
        .expireDate(dto.expireDate())
        .sentMemberName(dto.sentMemberName())
        .build();
  }

  public void update(GifticonInfoEditRequestDto dto) {
    this.name = dto.name();
    this.expireDate = dto.expireDate();
    this.storeName = dto.storeName();
    this.memo = dto.memo();
    this.isMoneyCoupon = dto.isMoneyCoupon();
    this.leftMoney = dto.leftMoney();
  }

  public void update(CustomCouponInfoEditRequestDto dto) {
    this.name = dto.name();
    this.expireDate = dto.expireDate();
    this.storeName = dto.storeName();
    this.sentMemberName = dto.sentMemberName();
    this.memo = dto.memo();
  }

}
