package com.nttdata.bancamicroservices.model.repository;

import com.nttdata.bancamicroservices.model.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD para clientes.
 */
@Repository
public interface ICustomerRepository extends ReactiveCrudRepository<Customer, Long> {

}
