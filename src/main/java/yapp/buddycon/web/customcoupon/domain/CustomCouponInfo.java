package yapp.buddycon.web.customcoupon.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class CustomCouponInfo {

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

  @Column(name = "expire_date")
  private Date expireDate;

}
