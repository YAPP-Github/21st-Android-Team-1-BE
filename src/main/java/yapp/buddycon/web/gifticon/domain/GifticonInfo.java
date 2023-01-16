package yapp.buddycon.web.gifticon.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class GifticonInfo {

  @Column(name = "barcode", nullable = false)
  private String barcode;

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
  private Date expireDate;

}
