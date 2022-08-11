package com.nttdata.bancamicroservices.model.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bancamicroservices.exception.UnknownEnumValueException;

public enum DocumentType {

  DNI("DNI"),
  CEX("Carnet de extranjeria"),
  PASSPORT("Pasaporte");

  private final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static DocumentType of(String value) {
    if (null == value) {
      return null;
    }

    for (DocumentType item : DocumentType.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new UnknownEnumValueException("AccountType: unknown value: " + value);
  }

  DocumentType(String value) {
    this.value = value;
  }
}
