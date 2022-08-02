package com.nttdata.bancamicroservices.model.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bancamicroservices.exception.UnknownEnumValueException;

/**
 * Tipo de clientes.
 */
public enum CustomerType {

  ENTERPRISE("E"),
  PERSONAL("P");

  private final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static CustomerType of(String value) {
    if (null == value) {
      return null;
    }

    for (CustomerType item : CustomerType.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }
    throw new UnknownEnumValueException("CustomerType: unknown value: " + value);
  }

  CustomerType(String value) {
    this.value = value;
  }

}

