package io.mtso.validation;

import com.fasterxml.jackson.databind.JsonNode;

public interface JsonValidator {
  void validate(JsonNode node) throws StructureValidatorException;
}
