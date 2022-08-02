package com.nttdata.bancamicroservices.model.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bancamicroservices.exception.UnknownEnumValueException;

/**
 * Tipos de creditos.
 */
public enum CreditType {
  PERSONAL("P"),
  ENTERPRISE("E"),
  CREDITCARD("C");

  private final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static CreditType of(String value) {
    if (null == value) {
      return null;
    }

    for (CreditType item : CreditType.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new UnknownEnumValueException("CreditTypeEnum: unknown value: " + value);
  }

  CreditType(String value) {
    this.value = value;
  }
}
