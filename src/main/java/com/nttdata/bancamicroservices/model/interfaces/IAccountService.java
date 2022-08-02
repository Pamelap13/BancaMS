package com.nttdata.bancamicroservices.model.interfaces;

import com.nttdata.bancamicroservices.model.domain.Account;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz de operaciones para las cuentas.
 */
public interface IAccountService {
  Flux<Account> getAllAccounts();
  Mono<Account> findById(String id);
  Mono<Account> createAccount(Account account) throws Exception;
  Mono<ResponseEntity<Account>> updateAccount(String id, Account account);
  Mono<Account> deleteById(String id);
}
