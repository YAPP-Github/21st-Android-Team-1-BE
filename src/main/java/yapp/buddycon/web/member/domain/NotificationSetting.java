package yapp.buddycon.web.member.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationSetting extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  private boolean activate;

  private boolean fourteenDaysLeft;

  private boolean sevenDaysLeft;

  private boolean threeDaysLeft;

  private boolean oneDaysLeft;

  // default: sevenDaysLeft = TRUE

  public static NotificationSetting create(Member member) {
    return NotificationSetting.builder()
      .member(member)
      .fourteenDaysLeft(false)
      .sevenDaysLeft(true)
      .threeDaysLeft(false)
      .oneDaysLeft(true)
      .build();
  }
}
