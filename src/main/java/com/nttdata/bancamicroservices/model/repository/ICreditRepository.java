package com.nttdata.bancamicroservices.model.repository;

import com.nttdata.bancamicroservices.model.domain.Credit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD para creditos.
 */
@Repository
public interface ICreditRepository extends ReactiveCrudRepository<Credit, String> {

}
