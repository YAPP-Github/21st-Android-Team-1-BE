package yapp.buddycon.web.notification.adaptor.in.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import yapp.buddycon.web.notification.application.port.in.response.NotificationResponseDto;

@AllArgsConstructor
@Getter
@Builder
public class NotificationResponse {

  private Long id;
  private String content;
  private boolean checked;

  public static NotificationResponse valueOf(NotificationResponseDto notificationResponseDto) {
    return NotificationResponse.builder()
        .id(notificationResponseDto.getNotificationId())
        .content(notificationResponseDto.getContent())
        .checked(notificationResponseDto.isChecked())
        .build();
  }

}
