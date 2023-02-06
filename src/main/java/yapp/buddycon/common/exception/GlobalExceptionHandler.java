package yapp.buddycon.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { CustomException.class })
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }

  @ExceptionHandler(value = { PersistenceException.class })
  protected ResponseEntity<ErrorResponse> handlePersistenceException(PersistenceException e) {
    log.error("handlePersistenceException throw PersistenceException : {}", e.getMessage());
    final ErrorResponse errorResponse = ErrorResponse.builder()
      .code("DatabaseException")
      .message("database error").build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(value = { MaxUploadSizeExceededException.class })
  public ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
    log.error("handleMaxUploadSizeExceededException throw MaxUploadSizeExceededException : {}", e.getMessage());
    final ErrorResponse errorResponse = ErrorResponse.builder()
      .code("MaxUploadSizeExceededException")
      .message("file size error").build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

}
