package yapp.buddycon.web.member.application.port.out;

import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;

public interface NotificationSettingQueryPort {

  NotificationSettingResponseDto findByMemberId(long memberId);

}
