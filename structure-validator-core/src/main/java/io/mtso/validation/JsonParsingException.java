package io.mtso.validation;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonParsingException extends StructureValidatorException {
  private final JsonProcessingException cause;

  public JsonParsingException(JsonProcessingException cause) {
    super(cause);
    this.cause = cause;
  }
}
