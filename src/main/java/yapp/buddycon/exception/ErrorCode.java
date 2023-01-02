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
  NOT_EXIST_ACCESS_TOKEN(BAD_REQUEST, "access token이 존재하지 않습니다."),
  EXPIRED_ACCESS_TOKEN(BAD_REQUEST, "만료된 JWT 토큰입니다."),
  MALFORMED_JWT_TOKEN(BAD_REQUEST, "잘못된 JWT 서명입니다."),
  UNSUPPORTED_JWT_TOKEN(BAD_REQUEST, "지원되지 않는 JWT 토큰입니다."),
  INVALID_JWT_TOKEN(BAD_REQUEST, "JWT 토큰이 잘못되었습니다."),

  ;

  private final HttpStatus httpStatus;
  private final String message;
}
