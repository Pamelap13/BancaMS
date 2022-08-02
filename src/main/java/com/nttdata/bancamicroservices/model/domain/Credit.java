package com.nttdata.bancamicroservices.model.domain;

import com.nttdata.bancamicroservices.model.domain.type.CreditType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de crfeditos.
 */
@Data
@Document(value = "credits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credit {

  @Id
  private String creditId;

  private Double limitCredit;

  private Double balance;

  private CreditType creditType;

  private String customerId;
}
