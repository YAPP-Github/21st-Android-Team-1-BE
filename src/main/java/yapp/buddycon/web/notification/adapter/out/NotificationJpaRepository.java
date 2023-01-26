package yapp.buddycon.web.notification.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.notification.domain.Notification;

public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {

}
