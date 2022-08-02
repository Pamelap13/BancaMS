package com.nttdata.bancamicroservices.service;

import com.nttdata.bancamicroservices.model.domain.Account;
import com.nttdata.bancamicroservices.model.domain.type.AccountType;
import com.nttdata.bancamicroservices.model.interfaces.IAccountService;
import com.nttdata.bancamicroservices.model.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio operacional de cuentas.
 */
@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

  @Autowired
  private final IAccountRepository accountRepository;

  @Override
  public Flux<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  @Override
  public Mono<Account> findById(String id) {
    return accountRepository.findById(id);
  }

  /**
  * validateAccount.

  * @param account

  * @throws Exception
  */
  private void validateAccount(Account account) throws Exception {
    if (account.getAccountType().equals(AccountType.SAVING) || account.getAccountType().equals(AccountType.TIMEDEPOSIT)) {
            account.setMaintenanceFee(false);
  } else {
        account.setMaintenanceFee(true); };
  }
  @Override
  public Mono<Account> createAccount(Account account) throws Exception {
    validateAccount(account);
    return accountRepository.save(account);
  }

  @Override
  public Mono<ResponseEntity<Account>> updateAccount(String id, Account account) {
    return accountRepository.findById(id)
                .flatMap(newAccount -> {
                    newAccount.setBalance(account.getBalance());
                    newAccount.setAccountType(account.getAccountType());
                    //newAccount.setCustomer(account.getCustomer());
                    return accountRepository.save(newAccount);
                })
                .map(updateAccount -> new ResponseEntity<>(updateAccount, HttpStatus.OK));

  }

  @Override
  public Mono<Account> deleteById(String id) {
    return accountRepository.findById(id)
                .flatMap(deleteAccount -> accountRepository.delete(deleteAccount)
                        .then(Mono.just(deleteAccount)));
  }
}
