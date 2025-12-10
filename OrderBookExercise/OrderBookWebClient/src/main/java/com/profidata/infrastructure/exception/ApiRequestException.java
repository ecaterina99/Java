package com.profidata.infrastructure.exception;

/**
 * Custom exception used to represent connection & HTTP errors
 */
public class ApiRequestException extends RuntimeException {
  private final int statusCode;
  private final String responseBody;

  // For HTTP errors
  public ApiRequestException(String message, int statusCode, String responseBody) {
    super(message + " (status " + statusCode + ")");
    this.statusCode = statusCode;
    this.responseBody = responseBody;
  }

  // For connection errors
  public ApiRequestException(String message) {
    super(message);
    this.statusCode = -1;
    this.responseBody = null;
  }

  // For wrapping IOException, InterruptedException
  public ApiRequestException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = -1;
    this.responseBody = null;
  }
}