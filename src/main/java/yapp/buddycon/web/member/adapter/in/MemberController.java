package yapp.buddycon.web.member.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

  @PatchMapping("/notification-setting")
  @Operation(summary = "유저 알림 설정 수정")
  public void updateNotificationSetting(AuthMember authMember,
      NotificationSettingUpdateRequestDto dto) {

  }

  @DeleteMapping("/self")
  @Operation(summary = "회원 탈퇴")
  public void deleteMember(AuthMember authMember) {

  }

}
