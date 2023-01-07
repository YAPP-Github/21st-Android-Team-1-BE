package yapp.buddycon.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { CustomException.class })
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }
}