package yapp.buddycon.web.coupon.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForCustomCouponCreationRequestDto;
import yapp.buddycon.web.coupon.adapter.in.request.SharedCouponForGifticonCreationRequestDto;
import yapp.buddycon.web.member.domain.Member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SharedCouponInfo {

  @Column(name = "barcode", nullable = false)
  private String barcode;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @OneToOne
  @JoinColumn(name = "member_id", nullable = false)
  private Member sentMember;

  @Column(name = "name", nullable = false, length = 16)
  private String name;

  @Column(name = "memo", length = 50)
  private String memo;

  @Column(name = "store_name", length = 16)
  private String storeName;

  @Column(name = "expire_date")
  private LocalDate expireDate;

  @Column(name = "shared_at")
  private LocalDateTime sharedAt;

  // TODO dto 다형성 적용
  public static SharedCouponInfo valueOf(SharedCouponForGifticonCreationRequestDto dto, String barcode, String imageUrl, Member sentMember) {
    return SharedCouponInfo.builder()
        .barcode(barcode)
        .imageUrl(imageUrl)
        .sentMember(sentMember)
        .name(dto.name())
        .memo(dto.memo())
        .storeName(dto.storeName())
        .expireDate(dto.expireDate())
        .build();
  }

  public static SharedCouponInfo valueOf(SharedCouponForCustomCouponCreationRequestDto dto, String imageUrl, Member sentMember) {
    return SharedCouponInfo.builder()
        .barcode(dto.barcodeNumber())
        .imageUrl(imageUrl)
        .sentMember(sentMember)
        .name(dto.name())
        .memo(dto.memo())
        .storeName(dto.storeName())
        .expireDate(dto.expireDate())
        .build();
  }

}
