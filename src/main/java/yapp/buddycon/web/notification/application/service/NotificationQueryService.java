package yapp.buddycon.web.notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.web.notification.application.port.in.NotificationQueryUseCase;
import yapp.buddycon.web.notification.application.port.in.response.NotificationResponseDto;
import yapp.buddycon.web.notification.application.port.out.NotificationQueryPort;
import yapp.buddycon.web.notification.domain.Notification;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class NotificationQueryService implements NotificationQueryUseCase {

  private final NotificationQueryPort notificationQueryPort;

  @Override
  public NotificationResponseDto getNotificationDetail(Long notificationId) {
    Notification notification = notificationQueryPort.findById(notificationId)
        .orElse(null);
    return NotificationResponseDto.valueOf(notification);
  }

}
