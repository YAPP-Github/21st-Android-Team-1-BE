package yapp.buddycon.web.sharedCoupon.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;

@Embeddable
public class SharedCouponInfo {

  @Column(name = "barcode", nullable = false)
  private String barcode;

  @Column(name = "name", nullable = false, length = 16)
  private String name;

  @Column(name = "memo", length = 50)
  private String memo;

  @Column(name = "store_name", length = 16)
  private String storeName;

  @Column(name = "coupon_type")
  private Date expireDate;

  @Column(name = "shared_at")
  private LocalDateTime sharedAt;

  @Column(name = "coupon_type")
  @Enumerated(EnumType.STRING)
  private CouponType couponType;

}
