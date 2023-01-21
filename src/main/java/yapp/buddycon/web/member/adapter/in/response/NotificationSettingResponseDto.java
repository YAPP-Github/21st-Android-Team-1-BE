package yapp.buddycon.web.member.adapter.in.response;

public record NotificationSettingResponseDto(
    long id,
    boolean activate,
    boolean fourteenDaysLeft,
    boolean sevenDaysLeft,
    boolean threeDaysLeft,
    boolean oneDaysLeft
) {

}
