package com.nttdata.bancamicroservices.api;

import com.nttdata.bancamicroservices.model.domain.BootcoinWallet;
import com.nttdata.bancamicroservices.service.BootcoinWalletService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api de monedero bootcoin.
 */
@RestController
@RequestMapping("/banca/bootcoinwallet")
public class BootcoinWalletController {
  private BootcoinWalletService bootcoinWalletService;

  public void create(@RequestBody BootcoinWallet bootcoinWallet) {
    bootcoinWalletService.create(bootcoinWallet);
  }
}
