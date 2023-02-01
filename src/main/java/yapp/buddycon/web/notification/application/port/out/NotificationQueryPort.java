package yapp.buddycon.web.notification.application.port.out;

import yapp.buddycon.web.notification.domain.Notification;

public interface NotificationQueryPort {

  Notification findNotificationById(Long notificationId);

}
