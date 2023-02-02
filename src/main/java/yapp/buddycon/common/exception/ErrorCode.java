package yapp.buddycon.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  // TODO 코드 바꾸기
  /* 400 BAD_REQUEST */
  INVALID_KAKAO_ACCESS_TOKEN(BAD_REQUEST, "유효하지 않은 카카오 access token입니다."),
  NOT_EXIST_ACCESS_TOKEN(BAD_REQUEST, "access token이 존재하지 않습니다."),
  EXPIRED_ACCESS_TOKEN(BAD_REQUEST, "만료된 JWT 토큰입니다."),
  MALFORMED_JWT_TOKEN(BAD_REQUEST, "잘못된 JWT 서명입니다."),
  UNSUPPORTED_JWT_TOKEN(BAD_REQUEST, "지원되지 않는 JWT 토큰입니다."),
  INVALID_JWT_TOKEN(BAD_REQUEST, "JWT 토큰이 잘못되었습니다."),
  LOGGED_OUT_MEMBER(BAD_REQUEST, "로그아웃된 사용자입니다."),
  TOKEN_MEMBER_INFO_IS_NOT_MATCH(BAD_REQUEST, "토큰의 사용자 정보가 일치하지 않습니다."),

  INVALID_SORT_PROPERTY(BAD_REQUEST, "잘못된 sort 방식입니다."),

  INVALID_COUPON_ID(BAD_REQUEST, "해당 쿠폰 id가 존재하지 않습니다."),
  INVALID_NOTIFICATION_ID(BAD_REQUEST, "해당 알림 id가 존재하지 않습니다."),
  INVALID_MEMBER_ID(BAD_REQUEST, "해당 회원 id가 존재하지 않습니다."),

  /* 403 FORBIDDEN */
  CANT_ACCESS_NOTIFICATION(FORBIDDEN, "해당 알림에 대한 권한이 없습니다."),

  NOT_EXIST_BARCODE_NUMBER(NO_CONTENT, "바코드에 해당하는 쿠폰이 존재하지 않습니다"),

  ;

  private final HttpStatus httpStatus;
  private final String message;
}
