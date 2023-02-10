package yapp.buddycon.web.member.adapter.out;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.member.domain.NotificationSetting;

public interface NotificationSettingJpaRepository extends JpaRepository<NotificationSetting, Long> {

  Optional<NotificationSetting> findByMemberId(long memberId);

}
