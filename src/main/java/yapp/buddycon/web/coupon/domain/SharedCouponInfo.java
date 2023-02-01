package yapp.buddycon.web.coupon.domain;


import yapp.buddycon.web.member.domain.Member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
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

}
