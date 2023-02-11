package yapp.buddycon.web.member.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.member.adapter.in.request.NotificationSettingUpdateRequestDto;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;
import yapp.buddycon.web.member.application.port.in.MemberUseCase;
import yapp.buddycon.web.member.application.port.out.NotificationSettingQueryPort;
import yapp.buddycon.web.member.domain.NotificationSetting;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService implements MemberUseCase {

  private final NotificationSettingQueryPort notificationSettingQueryPort;

  @Override
  public NotificationSettingResponseDto getMembersNotificationSetting(long memberId) {
    NotificationSetting notificationSetting = notificationSettingQueryPort.findByMemberId(memberId);
    return NotificationSettingResponseDto.valueOf(notificationSetting);
  }

  @Override
  @Transactional
  public DefaultResponseDto updateNotificationSetting(long memberId, NotificationSettingUpdateRequestDto dto) {
    NotificationSetting notificationSetting = notificationSettingQueryPort.findByMemberId(memberId);
    notificationSetting.update(dto);
    return new DefaultResponseDto(true, "알림 설정을 수정하였습니다.");
  }

}
