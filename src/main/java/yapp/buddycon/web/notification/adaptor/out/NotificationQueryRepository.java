package yapp.buddycon.web.notification.adaptor.out;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.notification.application.port.out.NotificationQueryPort;
import yapp.buddycon.web.notification.domain.Notification;

@Repository
@RequiredArgsConstructor
public class NotificationQueryRepository implements NotificationQueryPort {

  private final NotificationJpaRepository notificationJpaRepository;

  @Override
  public Optional<Notification> findById(Long notificationId) {
    return notificationJpaRepository.findById(notificationId);
  }
}
