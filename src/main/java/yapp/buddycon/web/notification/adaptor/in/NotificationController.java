package yapp.buddycon.web.notification.adaptor.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.notification.application.port.in.NotificationQueryUseCase;
import yapp.buddycon.web.notification.adaptor.in.response.NotificationResponse;
import yapp.buddycon.web.notification.application.port.in.response.NotificationResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
public class NotificationController {

  private final NotificationQueryUseCase notificationQueryUseCase;

  @GetMapping(value = "/{notification-id}")
  public ResponseEntity<NotificationResponse> getNotificationDetail(
      @PathVariable("notification-id") long notificationId) {
    NotificationResponseDto responseDto = notificationQueryUseCase.getNotificationDetail(notificationId);
    return ResponseEntity.ok(NotificationResponse.valueOf(responseDto));
  }

}
