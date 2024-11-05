package com.nbu.CSCB869.service.exceptions;

import com.nbu.CSCB869.service.exceptions.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorDto> handleBaseValidationException(BaseValidationException ex) {
        return ResponseEntity.unprocessableEntity().body(createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }

    private ErrorDto createHttpErrorInfo(HttpStatus httpStatus, String message) {
        log.debug("Returning HTTP status: {}, message: {}", httpStatus, message);
        return new ErrorDto(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase(), message);
    }
}
