package yapp.buddycon.web.notification.application.port.out;

import java.util.Optional;
import yapp.buddycon.web.notification.domain.Notification;

public interface NotificationQueryPort {

  Optional<Notification> findById(Long notificationId);

}
