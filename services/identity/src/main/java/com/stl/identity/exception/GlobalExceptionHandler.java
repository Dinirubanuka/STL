package com.stl.identity.exception;

import com.stl.identity.dto.response.ApiError;
import com.stl.identity.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorDTO> errorMessages = ex.getBindingResult().getAllErrors().stream()
                .map(objectError -> {
                    if (objectError instanceof FieldError) {
                        return new ErrorDTO("VALIDATION_FAILED!", ((FieldError) objectError).getDefaultMessage());
                    }
                    return new ErrorDTO("VALIDATION_FAILED!", objectError.getDefaultMessage());
                })
                .collect(Collectors.toList());

        // Get the first error
        ErrorDTO firstError = errorMessages.isEmpty() ? new ErrorDTO("VALIDATION_FAILED!", "Unknown validation error") : errorMessages.get(0);

        ApiError<ErrorDTO> apiError = new ApiError<>(HttpStatus.BAD_REQUEST.value(), firstError);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError<ErrorDTO>> handleUserNotFoundException(Exception ex, WebRequest req){
        ApiError<ErrorDTO> apiError = new ApiError<>(HttpStatus.NOT_FOUND.value(),new ErrorDTO("NOT_FOUND",ex.getMessage()));
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError<ErrorDTO>> handleGlobalException(Exception ex, WebRequest req){
        ApiError<ErrorDTO> apiError = new ApiError<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),new ErrorDTO("INTERNAL_SERVER_ERROR",ex.getMessage()));
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    };


}
