package yapp.buddycon.web.notification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.member.domain.Member;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity {

  @Column(name = "title", length = 50)
  private String title;

  @Column(name = "body", columnDefinition = "TEXT")
  private String body;

  private boolean checked;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne
  @JoinColumn(name = "coupon_id")
  private Coupon coupon;

  public boolean checkAuth(long memberId) {
    // 공지사항인 경우 member = null
    if (member != null) {
      return member.getId() == memberId;
    }
    return true;
  }
}
