package io.mtso.validation;

import com.networknt.schema.JsonSchemaFactory;

public interface JsonSchemaFactorySupplier<T> {
  public T newJsonSchemaFactory();
}
