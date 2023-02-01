package yapp.buddycon.web.notification.application.port.in;

import yapp.buddycon.web.notification.adapter.in.response.NotificationResponseDto;

public interface NotificationUseCase {

  NotificationResponseDto getNotification(Long memberId, Long notificationId);

}
