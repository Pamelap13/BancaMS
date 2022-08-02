package com.nttdata.bancamicroservices.api;

import com.nttdata.bancamicroservices.model.domain.Account;
import com.nttdata.bancamicroservices.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Api de cuentas.
 */
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/banca/accounts")
@Slf4j
public class AccountController {
  private final AccountService accountService;

  @GetMapping()
  public Flux<Account> getAllAccounts() {
    return accountService.getAllAccounts();
  }

  @GetMapping(path = {"{id}"}, produces = "application/json")
  public Mono<Account> findByid(@PathVariable String id) {
    return accountService.findById(id);
  }

  @PostMapping
  public Mono<Account> createCustomer(@RequestBody Account account)
      throws Exception {
    log.debug(account.toString());
    return accountService.createAccount(account);
  }

  @PutMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Account>> updateCustomer(@PathVariable String id,
                                                        @RequestBody Account account) {
    return accountService.updateAccount(id, account);
  }

  @DeleteMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Void>> deleteById(@PathVariable final String id) {
    return accountService.deleteById(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
