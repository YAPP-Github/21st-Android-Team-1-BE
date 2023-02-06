package yapp.buddycon.web.notification.adapter.out;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.notification.domain.Notification;

public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {

  List<Notification> findAllByMemberIdOrderByCreatedAtDesc(long memberId, Pageable pageable);

}
