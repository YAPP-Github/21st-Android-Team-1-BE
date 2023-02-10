package yapp.buddycon.web.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.member.application.port.out.NotificationSettingQueryPort;
import yapp.buddycon.web.member.domain.NotificationSetting;

@Repository
@RequiredArgsConstructor
public class NotificationSettingQueryRepository implements NotificationSettingQueryPort {

  private final NotificationSettingJpaRepository notificationSettingJpaRepository;

  @Override
  public NotificationSetting findByMemberId(long memberId) {
    return notificationSettingJpaRepository.findByMemberId(memberId).orElseThrow(() -> new CustomException(ErrorCode.NOTIFICATION_SETTING_NOT_FOUND));
  }

}
