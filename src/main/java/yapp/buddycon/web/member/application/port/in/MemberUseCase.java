package yapp.buddycon.web.member.application.port.in;

import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;

public interface MemberUseCase {

  NotificationSettingResponseDto getMembersNotificationSetting(long memberId);

}
