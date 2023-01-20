package yapp.buddycon.web.notification.application.port.in.response;

import lombok.Builder;
import lombok.Getter;
import yapp.buddycon.web.notification.domain.Notification;

@Getter
@Builder
public class NotificationResponseDto {

  private Long notificationId;
  private String content;
  private boolean checked;

  public static NotificationResponseDto valueOf(Notification notification) {
    return NotificationResponseDto.builder()
        .notificationId(notification.getId())
        .content(notification.getContent())
        .checked(notification.isChecked())
        .build();
  }

}
