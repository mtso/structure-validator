package io.mtso.validation;

public class Detail {
  private final String errorCode;
  private final String errorMessage;

  public Detail(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
