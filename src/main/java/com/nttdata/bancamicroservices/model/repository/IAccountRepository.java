package com.nttdata.bancamicroservices.model.repository;

import com.nttdata.bancamicroservices.model.domain.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD de cuentas.
 */
@Repository
public interface IAccountRepository extends ReactiveCrudRepository<Account, String> {
}
