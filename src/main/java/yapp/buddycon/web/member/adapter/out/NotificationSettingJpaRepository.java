package yapp.buddycon.web.member.adapter.out;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;
import yapp.buddycon.web.member.domain.NotificationSetting;

public interface NotificationSettingJpaRepository extends JpaRepository<NotificationSetting, Long> {

  @Query(value = """
      select new yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto(ns.id, ns.activate, ns.fourteenDaysLeft, ns.sevenDaysLeft, ns.threeDaysLeft, ns.oneDaysLeft)
      from NotificationSetting ns
      where ns.member.id = :memberId
  """)
  Optional<NotificationSettingResponseDto> findByMemberId(long memberId);

}
