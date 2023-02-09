package yapp.buddycon.web.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.auth.application.port.out.AuthToNotificationSettingCommandPort;
import yapp.buddycon.web.member.domain.NotificationSetting;

@Repository
@RequiredArgsConstructor
public class NotificationSettingCommandRepository implements AuthToNotificationSettingCommandPort {

  private final NotificationSettingJpaRepository notificationSettingJpaRepository;

  @Override
  public NotificationSetting save(NotificationSetting notificationSetting) {
    return notificationSettingJpaRepository.save(notificationSetting);
  }
}
