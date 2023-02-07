package yapp.buddycon.web.notification.application.port.in;

import java.util.List;
import yapp.buddycon.common.PagingDto;
import yapp.buddycon.web.notification.adapter.in.response.NotificationResponseDto;

public interface NotificationUseCase {

  List<NotificationResponseDto> getSortedNotifications(Long memberId, PagingDto pagingDto);

  NotificationResponseDto getNotification(Long memberId, Long notificationId);

}
