package yapp.buddycon.web.coupon.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
public class SharedCouponInfo {

  @Column(name = "barcode", nullable = false)
  private String barcode;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(name = "sent_member_id", nullable = false)
  private long sentMemberId;

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
