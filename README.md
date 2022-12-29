# structure-validator

Utilities to deserialize JSON and validate with schemas.

## Example Usage

```java
final Json json =
    Json.withValidator(
        JsonSchemaValidator.withSchema(
            JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4).getSchema(schema)));
final ObjectNode node = json.newObjectNodeAndValidate("{}");
```
