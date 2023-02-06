package yapp.buddycon.common;

import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;

public record PagingDto(
    int page,
    int size
) {

  public void checkValidation() {
    if (page < 0) {
      throw new CustomException(ErrorCode.INVALID_PAGE);
    }
    if (size <= 0 || size > 1000) {
      throw new CustomException(ErrorCode.INVALID_SIZE);
    }
  }

}
