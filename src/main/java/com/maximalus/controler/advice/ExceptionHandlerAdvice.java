package com.maximalus.controler.advice;

import com.maximalus.exception.NotFoundException;
import com.maximalus.exception.RestaurantManagerException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.BadRequestException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.maximalus.exception.ExceptionMessages.Authentication.ACCESS_DENIED;
import static com.maximalus.exception.ExceptionMessages.Authentication.BAD_CREDENTIALS;
import static com.maximalus.exception.ExceptionMessages.ConstraintMessages;
import static com.maximalus.exception.ExceptionMessages.ConstraintMessages.findByConstraintMessage;
import static com.maximalus.exception.ExceptionMessages.INVALID_REQUEST_PARAM;
import static com.maximalus.exception.ExceptionMessages.NOT_UNIQUE_VALUE;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private static final String EXCEPTION_LOG = "{} has occurred during processing request {}";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        logException(ex, ((ServletWebRequest) request).getRequest());
        List<String> errors = extractErrorMessages(ex);
        ErrorResponse response = new ErrorResponse(BAD_REQUEST, errors.get(0));
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex,
                                                                   HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(BAD_REQUEST, INVALID_REQUEST_PARAM);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                               HttpServletRequest request) {
        logException(ex, request);

        return mapConstraintToErrorResponse(ex.getCause());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentials(BadCredentialsException ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(HttpStatus.UNAUTHORIZED, BAD_CREDENTIALS);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(HttpStatus.FORBIDDEN, ACCESS_DENIED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoSuchElementException ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleException(Throwable ex, HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(RestaurantManagerException.class)
    public ResponseEntity<ErrorResponse> handleQnbException(RestaurantManagerException ex,
                                                            HttpServletRequest request) {
        logException(ex, request);
        return errorResponse(ex.getHttpStatus(), ex.getMessage());
    }

    public ResponseEntity<ErrorResponse> mapConstraintToErrorResponse(Throwable cause) {
        if (!(cause instanceof org.hibernate.exception.ConstraintViolationException)) {
            return errorResponse(BAD_REQUEST, NOT_UNIQUE_VALUE);
        }

        String constraintMessage = ((org.hibernate.exception.ConstraintViolationException) cause).getConstraintName();

        if (constraintMessage == null) return errorResponse(INTERNAL_SERVER_ERROR, cause.getMessage());

        ConstraintMessages result = findByConstraintMessage(constraintMessage);

        return errorResponse(result.getStatus(), result.getMessage());
    }

    private ResponseEntity<ErrorResponse> errorResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new ErrorResponse(status, message), status);
    }

    private List<String> extractErrorMessages(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().size() > ex.getBindingResult().getFieldErrors().size()
                ? ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList())
                : ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.toList());
    }

    private void logException(Throwable ex, HttpServletRequest request) {
        String errorMess = ex.getClass().getSimpleName() + ": " + ex.getCause();
        errorMess += ex.getStackTrace()[0].toString();

        log.error(EXCEPTION_LOG, errorMess, request.getMethod() + " " + request.getRequestURI());
        log.error(Marker.ANY_NON_NULL_MARKER, ex);
    }

    @Getter
    private static class ErrorResponse {
        public String timestamp;
        private String status;
        private int error;
        private String message;

        ErrorResponse(HttpStatus httpStatus, String message) {
            this.timestamp = LocalDateTime.now().format(ISO_DATE_TIME);
            this.error = httpStatus.value();
            this.status = httpStatus.getReasonPhrase();
            this.message = message;
        }
    }
}
