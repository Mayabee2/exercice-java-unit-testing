package com.unitTesting.crm.exception;

public class NotAllowedException extends RuntimeException {
  public NotAllowedException(String errorMessage) {
    super(errorMessage);
  }
}
