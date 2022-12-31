package yapp.buddycon.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 400 BAD_REQUEST */
  INVALID_KAKAO_ACCESS_TOKEN(BAD_REQUEST, "유효하지 않은 카카오 access token입니다."),

  ;

  private final HttpStatus httpStatus;
  private final String message;
}
