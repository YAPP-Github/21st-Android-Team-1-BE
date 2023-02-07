package yapp.buddycon.web.notification.application.port.out;

import java.util.List;
import org.springframework.data.domain.Pageable;
import yapp.buddycon.web.notification.domain.Notification;

public interface NotificationQueryPort {

  List<Notification> findAllByMemberIdAndOrderByCreatedAt(long memberId, Pageable pageable);

  Notification findNotificationById(Long notificationId);

}
