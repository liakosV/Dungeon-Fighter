package gr.project.dungeonFighter.core;

import gr.project.dungeonFighter.core.exceptions.*;
import gr.project.dungeonFighter.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppObjectAccessDeniedException.class)
    public ResponseEntity<ErrorResponseDto> handleAccessDenied(AppObjectAccessDeniedException e) {
        return ErrorResponseHelper(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AppObjectAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleAlreadyExists(AppObjectAlreadyExistException e) {
        return ErrorResponseHelper(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AppObjectInvalidArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidArgument(AppObjectInvalidArgumentException e) {
        return ErrorResponseHelper(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppObjectNotAuthorizedException.class)
    public ResponseEntity<ErrorResponseDto> handleNotAuthorized(AppObjectNotAuthorizedException e) {
        return ErrorResponseHelper(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AppObjectNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(AppObjectNotFoundException e) {
        return ErrorResponseHelper(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleUnexpected(Exception e) {
        ErrorResponseDto response = new ErrorResponseDto(
                "INTERNAL_ERROR",
                "An unexpected server error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponseDto> ErrorResponseHelper(AppGenericException e, HttpStatus status) {
        ErrorResponseDto response = new ErrorResponseDto(
                e.getCode(),
                e.getMessage(),
                status.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, status);
    }
}
