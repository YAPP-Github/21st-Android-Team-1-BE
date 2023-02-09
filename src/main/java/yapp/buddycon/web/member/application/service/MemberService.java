package yapp.buddycon.web.member.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;
import yapp.buddycon.web.member.application.port.in.MemberUseCase;
import yapp.buddycon.web.member.application.port.out.NotificationSettingQueryPort;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService implements MemberUseCase {

  private final NotificationSettingQueryPort notificationSettingQueryPort;

  @Override
  public NotificationSettingResponseDto getMembersNotificationSetting(long memberId) {
    return notificationSettingQueryPort.findByMemberId(memberId);
  }
}