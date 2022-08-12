package com.nttdata.bancamicroservices.service;

import com.nttdata.bancamicroservices.model.domain.BootcoinWallet;
import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Servicio bootcoin.
 */
@EnableBinding(Source.class)
@Service
public class BootcoinWalletService {

  @Autowired
  private Source source;

  @SendTo
  public boolean create(BootcoinWallet bootcoinWallet) {
    return source.output().send(MessageBuilder.withPayload(bootcoinWallet).build());
  }
}
