package yapp.buddycon.web.member.application.port.in;

import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;

public interface MemberUseCase {

  NotificationSettingResponseDto getMembersNotificationSetting(long memberId);

  DefaultResponseDto deleteMember(Long id);

}
