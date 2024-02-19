package com.vtxlab.bootcamp.crypto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.crypto.infra.ApiRes;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RestClientException.class) // catch
  @ResponseStatus(value = HttpStatus.BAD_GATEWAY) // TBC.
  public ApiRes<Void> apiErrorExceptionHandler(RestClientException e) {
    return ApiRes.<Void>builder() //
        .code(ExceptionEnum.API_ERROR.getCode()) //
        .message(ExceptionEnum.API_ERROR.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(InvalidInputException.class) // catch
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // TBC.
  public ApiRes<Void> invalidInputExceptionHandler(InvalidInputException e) {
    return ApiRes.<Void>builder() //
        .code(ExceptionEnum.INVALID_INPUT.getCode()) //
        .message(ExceptionEnum.INVALID_INPUT.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(InvalidOpeartionException.class) // catch
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // TBC.
  public ApiRes<Void> inavalidOperationExceptionHandler(InvalidOpeartionException e) {
    return ApiRes.<Void>builder() //
        .code(ExceptionEnum.INVALID_OPERATION.getCode()) //
        .message(ExceptionEnum.INVALID_OPERATION.getMessage()) //
        .data(null) //
        .build();
  }

}
