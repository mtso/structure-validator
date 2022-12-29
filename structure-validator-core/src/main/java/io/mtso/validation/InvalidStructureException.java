package io.mtso.validation;

public class InvalidStructureException extends StructureValidatorException {
  private final String message;

  public InvalidStructureException(String message) {
    super(message);
    this.message = message;
  }
}
