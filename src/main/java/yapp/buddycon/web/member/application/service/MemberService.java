package yapp.buddycon.web.member.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.member.adapter.in.request.NotificationSettingUpdateRequestDto;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;
import yapp.buddycon.web.member.application.port.in.MemberUseCase;
import yapp.buddycon.web.member.application.port.out.MemberCommandPort;
import yapp.buddycon.web.member.application.port.out.MemberQueryPort;
import yapp.buddycon.web.member.application.port.out.NotificationSettingQueryPort;
import yapp.buddycon.web.member.domain.NotificationSetting;
import yapp.buddycon.web.member.domain.Member;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

  private final NotificationSettingQueryPort notificationSettingQueryPort;
  private final MemberQueryPort memberQueryPort;
  private final MemberCommandPort memberCommandPort;

  @Override
  @Transactional(readOnly = true)
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


  @Override
  @Transactional
  public DefaultResponseDto deleteMember(Long id) {
    Member member = memberQueryPort.findById(id);
    member.delete();
    return new DefaultResponseDto(true, "탈퇴되었어요");
  }
}
