package yapp.buddycon.web.notification.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.notification.application.port.out.NotificationQueryPort;
import yapp.buddycon.web.notification.domain.Notification;

@Repository
@RequiredArgsConstructor
public class NotificationQueryRepository implements NotificationQueryPort {

  private final NotificationJpaRepository notificationJpaRepository;

  @Override
  public Notification findNotificationById(Long notificationId) {
    return notificationJpaRepository.findById(notificationId)
        .orElseThrow(() -> new CustomException(ErrorCode.INVALID_NOTIFICATION_ID));
  }
}
