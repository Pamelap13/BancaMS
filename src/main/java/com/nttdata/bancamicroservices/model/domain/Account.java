package com.nttdata.bancamicroservices.model.domain;

import com.nttdata.bancamicroservices.model.domain.type.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de cuentas.
 */
@Data
@Document(value = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
  @Id
  private String accountId;

  private String customerId;

  private String accountNumber;

  private Float balance;

  private AccountType accountType;

  private Boolean maintenanceFee;

  private Integer monthlyMovement;

}
