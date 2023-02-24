package yapp.buddycon.common.response;

public record DefaultIdResponseDto (
  Long id,
  boolean success,
  String message
) {

}
