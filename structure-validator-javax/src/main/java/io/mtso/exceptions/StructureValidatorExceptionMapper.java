package io.mtso.exceptions;

import io.mtso.validation.StructureValidatorException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * environment.jersey().register(
 * StructureValidatorExceptionMapper.withStructureValidatorExceptionMapper(new );
 */
public class StructureValidatorExceptionMapper
    implements ExceptionMapper<StructureValidatorException> {
  @Override
  public Response toResponse(StructureValidatorException e) {
    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
  }
}
