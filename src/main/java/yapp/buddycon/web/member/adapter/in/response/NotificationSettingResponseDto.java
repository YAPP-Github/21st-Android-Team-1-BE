package yapp.buddycon.web.member.adapter.in.response;

public record NotificationSettingResponseDto(
    Long id,
    boolean activate,
    boolean fourteenDaysLeft,
    boolean sevenDaysLeft,
    boolean threeDaysLeft,
    boolean oneDaysLeft
) {

}
