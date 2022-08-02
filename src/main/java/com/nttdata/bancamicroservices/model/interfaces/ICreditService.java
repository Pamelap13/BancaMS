package com.nttdata.bancamicroservices.model.interfaces;

import com.nttdata.bancamicroservices.model.domain.Credit;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz de operaciones para creditos.
 */
public interface ICreditService {
  Flux<Credit> getAllCredits();
  Mono<Credit> findById(String id);
  Mono<Credit> createCredit(Credit credit);
  Mono<ResponseEntity<Credit>> updateCredit(String id, Credit credit);
  Mono<Credit> deleteById(String id);
}
