package yapp.buddycon.web.coupon.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import lombok.Getter;

@Embeddable
@Getter
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

}
