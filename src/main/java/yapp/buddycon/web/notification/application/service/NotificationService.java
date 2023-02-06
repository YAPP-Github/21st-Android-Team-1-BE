package yapp.buddycon.web.notification.application.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.PagingDto;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.notification.adapter.in.response.NotificationResponseDto;
import yapp.buddycon.web.notification.application.port.in.NotificationUseCase;
import yapp.buddycon.web.notification.application.port.out.NotificationQueryPort;
import yapp.buddycon.web.notification.domain.Notification;

@Service
@RequiredArgsConstructor
public class NotificationService implements NotificationUseCase {

  private final NotificationQueryPort notificationQueryPort;

  @Transactional
  @Override
  public List<NotificationResponseDto> getSortedNotifications(Long memberId, PagingDto pagingDto) {
    pagingDto.checkValidation();
    PageRequest pageRequest = PageRequest.of(pagingDto.page(), pagingDto.size());
    List<Notification> notificationList = notificationQueryPort.findAllByMemberIdAndOrderByCreatedAt(memberId, pageRequest);

    for (Notification notification : notificationList) {
      notification.setCheckedTrue();
    }
    return notificationList.stream().map(NotificationResponseDto::valueOf).collect(Collectors.toList());
  }

  @Override
  public NotificationResponseDto getNotification(Long memberId, Long notificationId) {
    Notification notification = notificationQueryPort.findNotificationById(notificationId);
    if (!notification.checkAuth(memberId)) {
      throw new CustomException(ErrorCode.CANT_ACCESS_NOTIFICATION);
    }
    return NotificationResponseDto.valueOf(notification);
  }
}
