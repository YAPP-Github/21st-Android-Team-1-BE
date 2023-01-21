package yapp.buddycon.web.member.adapter.in.request;

public record NotificationSettingUpdateRequestDto(
    Boolean activate,
    Boolean fourteenDaysLeft,
    Boolean sevenDaysLeft,
    Boolean threeDaysLeft,
    Boolean oneDaysLeft
) {

}
