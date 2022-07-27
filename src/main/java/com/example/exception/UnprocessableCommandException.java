package com.example.exception;

public class UnprocessableCommandException extends RuntimeException {

  public UnprocessableCommandException(String s) {
    super(s);
  }
}
