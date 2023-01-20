package yapp.buddycon.web.member.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.member.adapter.in.request.NotificationSettingUpdateRequestDto;
import yapp.buddycon.web.member.adapter.in.response.NotificationSettingResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {

  @GetMapping("/notification-setting")
  @Operation(summary = "유저 알림 설정 조회")
  public NotificationSettingResponseDto getNotificationSetting(AuthMember authMember) {
    NotificationSettingResponseDto dto = null;
    return dto;
  }

  @PutMapping("/notification-setting")
  @Operation(summary = "유저 알림 설정 수정")
  public void updateNotificationSetting(AuthMember authMember,
      NotificationSettingUpdateRequestDto dto) {

  }

}