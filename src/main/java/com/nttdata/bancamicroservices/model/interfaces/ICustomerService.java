package com.nttdata.bancamicroservices.model.interfaces;

import com.nttdata.bancamicroservices.model.domain.Customer;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz de operaciones para clientes.
 */
public interface ICustomerService {
  Flux<Customer> getAllCustomer();
  Mono<Customer> findById(Long id);
  Mono<Customer> createCustomer(Customer customer);
  Mono<ResponseEntity<Customer>> updateCustomer(Long id, Customer customer);
  Mono<Customer> deleteById(Long id);
}
