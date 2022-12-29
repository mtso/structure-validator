package io.mtso.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;

public class Json {
  private final ObjectMapper mapper;
  private final JsonValidator validator;

  private Json(final ObjectMapper mapper, final JsonValidator validator) {
    this.mapper = Objects.requireNonNull(mapper, "An ObjectMapper is required");
    this.validator = Objects.requireNonNull(validator, "A JsonValidator is required");
  }

  public ObjectNode newObjectNodeAndValidate(final String jsonString)
      throws StructureValidatorException {
    final JsonNode node;
    try {
      node = mapper.readTree(jsonString);
    } catch (final JsonProcessingException e) {
      throw new JsonParsingException(e);
    }

    if (!node.isObject()) {
      throw new InvalidStructureException(
          String.format("Expected node to be 'object' but got %s", node.getNodeType().toString()));
    }

    validator.validate(node);
    return (ObjectNode) node;
  }

  public static Json withValidator(JsonSchemaValidator validator) {
    return new Builder().setMapper(new ObjectMapper()).setValidator(validator).build();
  }

  static class Builder {
    private ObjectMapper mapper;
    private JsonValidator validator;

    Builder() {}

    public Builder setMapper(ObjectMapper mapper) {
      this.mapper = mapper;
      return this;
    }

    public Builder setValidator(JsonValidator validator) {
      this.validator = validator;
      return this;
    }

    public Json build() {
      return new Json(this.mapper, this.validator);
    }
  }
}
