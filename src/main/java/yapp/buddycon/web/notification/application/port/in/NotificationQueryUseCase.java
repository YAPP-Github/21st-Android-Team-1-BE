package yapp.buddycon.web.notification.application.port.in;

import yapp.buddycon.web.notification.application.port.in.response.NotificationResponseDto;

public interface NotificationQueryUseCase {

  NotificationResponseDto getNotificationDetail(Long notificationId);

}
