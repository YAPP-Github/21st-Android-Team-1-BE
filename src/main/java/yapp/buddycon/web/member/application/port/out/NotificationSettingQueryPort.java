package yapp.buddycon.web.member.application.port.out;

import yapp.buddycon.web.member.domain.NotificationSetting;

public interface NotificationSettingQueryPort {

  NotificationSetting findByMemberId(long memberId);

}
