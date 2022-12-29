package io.mtso.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class JsonSchemaValidator implements JsonValidator {
  private final JsonSchema jsonSchema;

  private JsonSchemaValidator(final JsonSchema jsonSchema) {
    this.jsonSchema = jsonSchema;
  }

  public static JsonSchemaValidator withSchema(JsonSchema jsonSchema) {
    return new JsonSchemaValidator(jsonSchema);
  }

  @Override
  public void validate(JsonNode node) throws StructureValidatorException {
    final Set<ValidationMessage> errors = jsonSchema.validate(node);

    final StructureValidatorException validatorException =
        new StructureValidatorException("Invalid schema");

    int errorCount = 0;

    for (final ValidationMessage error : errors) {
      errorCount++;
      switch (error.getType()) {
        case "required":
          validatorException.addDetail(
              new Detail(
                  "MISSING_REQUIRED",
                  String.format("Missing required field: '%s'", error.getArguments()[0])));
          break;
        default:
          break;
      }
    }

    if (errorCount > 0) {
      throw validatorException;
    }
  }
}
