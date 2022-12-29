package io.mtso.exceptions;

import io.mtso.validation.StructureValidatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class StructureValidatorExceptionMapperTest {
  @Test
  public void testToResponse() {
    final Response response =
        new StructureValidatorExceptionMapper()
            .toResponse(new StructureValidatorException("test reason"));
    Assertions.assertEquals(400, response.getStatus());
  }
}
