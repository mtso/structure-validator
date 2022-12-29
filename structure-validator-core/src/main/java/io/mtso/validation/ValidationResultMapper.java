package io.mtso.validation;

public interface ValidationResultMapper<T> {
  public StructureValidatorException mapResultToException(T errors);
}
