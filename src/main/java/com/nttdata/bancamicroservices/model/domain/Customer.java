package com.nttdata.bancamicroservices.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.bancamicroservices.model.domain.type.CustomerType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de clientes.
 */
@Data
@Document (value = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @Id
  private String customerId;

  private String lastName;

  private String firstName;

  private String dni;

  private Integer age;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private Date birthday;

  private CustomerType customerType;

}
