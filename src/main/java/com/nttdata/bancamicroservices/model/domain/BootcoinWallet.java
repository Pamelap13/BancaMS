package com.nttdata.bancamicroservices.model.domain;

import com.nttdata.bancamicroservices.model.domain.type.DocumentType;
import org.springframework.data.annotation.Id;

public class BootcoinWallet {

  @Id
  private String bootcoinId;
  private DocumentType documentType;
  private String documentNumber;
  private String numberPhone;
  private String eMail;
}
