package yapp.buddycon.web.auth.application.port.out;

import yapp.buddycon.web.member.domain.NotificationSetting;

public interface AuthToNotificationSettingCommandPort {
  NotificationSetting save(NotificationSetting notificationSetting);
}
