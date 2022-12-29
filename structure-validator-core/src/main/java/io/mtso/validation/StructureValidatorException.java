package io.mtso.validation;

import java.util.LinkedList;
import java.util.List;

public class StructureValidatorException extends Exception {
  private final List<Detail> details = new LinkedList<>();

  public StructureValidatorException(Throwable cause) {
    super(cause);
  }

  public StructureValidatorException(String message) {
    super(message);
  }

  public StructureValidatorException addDetail(Detail detail) {
    this.details.add(detail);
    return this;
  }

  public List<Detail> getDetails() {
    return details;
  }
}
