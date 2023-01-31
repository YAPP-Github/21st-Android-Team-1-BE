package yapp.buddycon.web.notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.notification.adapter.in.response.NotificationResponseDto;
import yapp.buddycon.web.notification.application.port.in.NotificationUseCase;
import yapp.buddycon.web.notification.application.port.out.NotificationQueryPort;
import yapp.buddycon.web.notification.domain.Notification;

@Service
@RequiredArgsConstructor
public class NotificationService implements NotificationUseCase {

  private final NotificationQueryPort notificationQueryPort;

  @Override
  public NotificationResponseDto getNotification(Long memberId, Long notificationId) {
    Notification notification = notificationQueryPort.findNotificationById(notificationId);
    if (!notification.checkAuth(memberId)) {
      throw new CustomException(ErrorCode.CANT_ACCESS_NOTIFICATION);
    }
    return NotificationResponseDto.valueOf(notification);
  }
}
