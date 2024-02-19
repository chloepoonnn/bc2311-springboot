package com.vtxlab.bootcamp.bootcampsbcalculator.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumSyscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DividedByZeroException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> handleException(DividedByZeroException e) {
    return ApiResponse.<Void>builder() //
        .code(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getCode()) //
        .message(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(InvalidOperation.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> handleException(InvalidOperation e) {
    return ApiResponse.<Void>builder() //
        .code(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getCode()) //
        .message(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> handleException(BusinessException e) {
    return ApiResponse.<Void>builder() //
        .code(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getCode()) //
        .message(EnumSyscode.DIVIDEDBYZERO_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }
}
