package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.ToString;

// chain methods
// ApiResponse.<User>builder().code(xxx).message(xxx).data(xxx).build();

// ApiResponse is for serialization, getter & setter are required.
// For deserialization (RestTemplate call -> objectmapper), only getter is required.
// For deserialization (controller(spring) -> objectmapper), No getter & setter is required.

// RestTemplate.getForObject() is similar to redisHelper.get(key)

// RedisTemplate

// @Getter
// @Builder
@ToString
public class ApiResp<T> {

  // NO getter, setter, empty constructor

  // private Syscode status;
  private String code;

  private String message;

  private T data;

  public ApiResp(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    // this.status = Syscode.valueOf(builder.code);
    this.data = builder.data;
  }

  public static <T> ApiResponseBuilder<T> builder() { // user self-define T
    ApiResponseBuilder<T> apiResponseBuilder = new ApiResponseBuilder<>();
    // apiResponseBuilder.code(Syscode.OK.getCode());
    // apiResponseBuilder.message(Syscode.OK.getMessage());

    return new ApiResponseBuilder<>();
  }

  // builder
  public static class ApiResponseBuilder<T> {

    private String code;
    private String message;
    private Syscode status;
    private T data;

    public ApiResponseBuilder<T> code(String code) { // instance method
      this.code = code;
      return this;
    }

    public ApiResponseBuilder<T> message(String message) { // instance method
      this.message = message;
      return this;
    }

    public ApiResponseBuilder<T> data(T data) { // instance method
      this.data = data;
      return this;
    }

    public ApiResponseBuilder<T> status(Syscode syscode) { // instance method
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
    }

    public ApiResponseBuilder<T> concatCustomMessage(String customMsg) { // instance method
      if (this.code == null || this.message == null || customMsg.isBlank())
        throw new RuntimeException();
      this.message = this.message.concat(customMsg);
      return this;
    }

    public ApiResponseBuilder<T> ok() {
      this.code = Syscode.OK.getCode();
      this.message = Syscode.OK.getMessage();
      return this;
    }

    public ApiResp<T> build() { // instance method -> this
      if (this.code == null || this.message == null)
        throw new RuntimeException();
      return new ApiResp<>(this);
    }
  }

  public static void main(String[] args) {
    ApiResp<String> apiResp = ApiResp.<String>builder()//
        // .code(Syscode.OK.getCode())//
        // .message(Syscode.OK.getMessage())//
        // .ok()//
        .status(Syscode.OK) //
        .data("Hello")//
        .build();
    System.out.println(apiResp.toString());
  }

}
