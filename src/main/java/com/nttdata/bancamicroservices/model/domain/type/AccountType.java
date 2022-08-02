package com.nttdata.bancamicroservices.model.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bancamicroservices.exception.UnknownEnumValueException;

/**
 * Tipos de cuentas.
 */
public enum AccountType {
  SAVING("S"),
  CURRENTACCOUNT("C"),
  TIMEDEPOSIT("T");

  private final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static AccountType of(String value) {
    if (null == value) {
      return null;
    }

    for (AccountType item : AccountType.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new UnknownEnumValueException("AccountType: unknown value: " + value);
  }

  AccountType(String value) {
    this.value = value;
  }

}
