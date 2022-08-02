package com.nttdata.bancamicroservices.service;

import com.nttdata.bancamicroservices.model.domain.Customer;
import com.nttdata.bancamicroservices.model.interfaces.ICustomerService;
import com.nttdata.bancamicroservices.model.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio operacional de clientes.
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

  @Autowired
  private final ICustomerRepository customerRepository;

  @Override
  public Flux<Customer> getAllCustomer() {
    return customerRepository.findAll();
  }

  @Override
  public Mono<Customer> findById(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public Mono<Customer> createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Mono<ResponseEntity<Customer>> updateCustomer(Long id, Customer customer) {
    return customerRepository.findById(id)
      .flatMap(oldCustomer -> {
        oldCustomer.setAge(customer.getAge());
        oldCustomer.setLastName(customer.getLastName());
        return customerRepository.save(oldCustomer);
      })
      .map(updateCustomer -> new ResponseEntity<>(updateCustomer, HttpStatus.OK));
  }

  @Override
  public Mono<Customer> deleteById(Long id) {
    return customerRepository.findById(id)
      .flatMap(deleteCustomer -> customerRepository.delete(deleteCustomer)
        .then(Mono.just(deleteCustomer)));
  }


}
