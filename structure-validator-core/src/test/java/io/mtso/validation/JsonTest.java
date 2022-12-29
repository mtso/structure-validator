package io.mtso.validation;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JsonTest {
  @Test
  public void testNewObjectNodeAndValidate() throws StructureValidatorException {
    final String schema = "{\"type\": \"object\"}";
    final Json json =
        Json.withValidator(
            JsonSchemaValidator.withSchema(
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4).getSchema(schema)));
    final ObjectNode node = json.newObjectNodeAndValidate("{}");
    Assertions.assertEquals(JsonNodeFactory.instance.objectNode(), node);
  }

  @Test
  public void testNewObjectNodeAndValidate_throwsRequired() {
    final String schema = Resource.loadToString("/schema/foo.schema.json");
    //        "{\n"
    //            + "  \"type\": \"object\",\n"
    //            + "  \"properties\": {\n"
    //            + "    \"foo\": {\n"
    //            + "      \"type\": \"string\"\n"
    //            + "    }\n"
    //            + "  },\n"
    //            + "  \"required\": [\"foo\"]\n"
    //            + "}";
    final Json json =
        Json.withValidator(
            JsonSchemaValidator.withSchema(
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4).getSchema(schema)));
    Assertions.assertThrows(
        StructureValidatorException.class, () -> json.newObjectNodeAndValidate("{}"));
  }
}
