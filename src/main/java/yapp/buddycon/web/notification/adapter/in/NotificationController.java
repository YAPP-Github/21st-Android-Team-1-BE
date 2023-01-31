package yapp.buddycon.web.notification.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.notification.adapter.in.response.NotificationResponseDto;
import yapp.buddycon.web.notification.application.port.in.NotificationUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

  private final NotificationUseCase notificationUseCase;

  @GetMapping("")
  @Operation(summary = "알림 정렬 조회", description = "알림 목록 조회 및 확인 완료 처리")
  public List<NotificationResponseDto> getNotifications(AuthMember authMember,
      Pageable pageable) {
    List<NotificationResponseDto> result = null;
    return result;
  }

  @GetMapping("/{id}")
  @Operation(summary = "알림 상세 조회")
  public NotificationResponseDto getNotificationInfo(AuthMember authMember,
      @PathVariable(value = "id") Long id) {
    NotificationResponseDto result = notificationUseCase.getNotification(authMember.id(), id);
    return result;
  }

}
