package yapp.buddycon.web.member.adapter.in.response;

import yapp.buddycon.web.member.domain.NotificationSetting;

public record NotificationSettingResponseDto(
    long id,
    boolean activate,
    boolean fourteenDaysLeft,
    boolean sevenDaysLeft,
    boolean threeDaysLeft,
    boolean oneDaysLeft
) {

  public static NotificationSettingResponseDto valueOf(NotificationSetting notificationSetting) {
    return new NotificationSettingResponseDto(
        notificationSetting.getId(),
        notificationSetting.isActivate(),
        notificationSetting.isFourteenDaysLeft(),
        notificationSetting.isSevenDaysLeft(),
        notificationSetting.isThreeDaysLeft(),
        notificationSetting.isOneDaysLeft()
    );
  }

}
