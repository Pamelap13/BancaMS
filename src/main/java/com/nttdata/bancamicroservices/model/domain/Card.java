package com.nttdata.bancamicroservices.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

  @Id
  private Integer id;

  private String number;

  private String clave;

  private List<Account> accounts;
}
