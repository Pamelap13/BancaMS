package com.nttdata.bancamicroservices.api;


import com.nttdata.bancamicroservices.model.domain.Customer;
import com.nttdata.bancamicroservices.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
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
 * Api de clientes.
 */
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/banca/customers")
@Slf4j
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping()
  public Flux<Customer> getAllCustomer() {
    log.info("getAllCustomer " + HttpStatus.OK);
    return customerService.getAllCustomer();
  }

  @GetMapping(path = {"{id}"}, produces = "application/json")
  public Mono<Customer> findByid(@PathVariable Long id) {
    log.info("findByidCustomer " + HttpStatus.OK);
    return customerService.findById(id);
  }

  @PostMapping
  public Mono<Customer> createCustomer(@RequestBody Customer customer) {
    log.info("createCustomer " + HttpStatus.OK);
    log.debug(customer.toString());
    return customerService.createCustomer(customer);
  }

  @PutMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable Long id,
                                                       @RequestBody Customer customer) {
    log.info("updateCustomer " + HttpStatus.OK);
    log.debug(customer.toString());

    return customerService.updateCustomer(id, customer);
  }

  @DeleteMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Void>> deleteById(@PathVariable Long id) {
    log.info("deleteByIdCustomer " + HttpStatus.OK);
    log.debug(id.toString());
    return customerService.deleteById(id)
      .map(r -> ResponseEntity.ok().<Void>build())
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
