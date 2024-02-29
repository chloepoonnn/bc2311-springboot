package com.vtxlab.bootcamp.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.GlobalExceptionHandler;
import com.vtxlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RequestParamException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

@RestControllerAdvice // @ContollerAdvice + @ResponseBody
public class LocalExceptionHandler extends GlobalExceptionHandler {

  @ExceptionHandler(JPHClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  // @ResponseStatus is an alternative of ResponseEntitiy<>
  public ApiResp<Void> jphClientExceptionHandler(JPHClientException e) {
    return ApiResp.<Void>builder() //
        .status(Syscode.JPH_NOT_AVALIABLE) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(JPHClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  // @ResponseStatus is an alternative of ResponseEntitiy<>
  public ApiResp<Void> requestParamException(RequestParamException e) {
    return ApiResp.<Void>builder() //
        .status(Syscode.REQUEST_PARAM_EXCEPTION) //
        .data(null) //
        .build();

  }

}
