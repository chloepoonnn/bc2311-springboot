package com.vtxlab.bootcamp.bootcampsbforum.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

@RestControllerAdvice // @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(JPHClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  // @ResponseStatus is an alternative of ResponseEntitiy<>
  public ApiResp<Void> jphClientExceptionHandler(JPHClientException e) {
    return ApiResp.<Void>builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(RestClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT) // TBC
  public ApiResp<Void> jphClientExceptionHandler(RestClientException e) {
    return ApiResp.<Void>builder() //
        .code(Syscode.REST_CLIENT_EXCEPTION.getCode()) //
        .message(Syscode.REST_CLIENT_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(ResourceNotFound.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResp<Void> npeExceptionHandler(ResourceNotFound e) {
    return ApiResp.<Void>builder() //
        .code(Syscode.NOTFOUND.getCode()) //
        .message(Syscode.NOTFOUND.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> npeExceptionHandler(NullPointerException e) {
    return ApiResp.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  // @ExceptionHandler(Exception.class)
  // @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  // public ApiResp<Void> npeExceptionHandler(Exception e) {
  //   return ApiResp.<Void>builder() //
  //       .code(Syscode.GENERAL_EXCEPTION.getCode()) //
  //       .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
  //       .data(null) //
  //       .build();
  // }

}
