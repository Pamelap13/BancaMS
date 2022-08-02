package com.nttdata.bancamicroservices.api;

import com.nttdata.bancamicroservices.model.domain.Credit;
import com.nttdata.bancamicroservices.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * Api de creditos.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/banca/credits")
@Slf4j
public class CreditController {

  private final CreditService creditService;

  @GetMapping()
  public Flux<Credit> getAllCredits() {
    return creditService.getAllCredits();
  }

  @GetMapping(path = {"{id}"}, produces = "application/json")
  public Mono<Credit> findById(@PathVariable String id) {
    return creditService.findById(id);
  }

  @PostMapping
  public Mono<Credit> createCredit(@RequestBody Credit credit) {
    log.info(credit.toString());
    return creditService.createCredit(credit);
  }

  @PutMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Credit>> updateCredit(@PathVariable String id,
                                                   @RequestBody Credit credit) {
    return creditService.updateCredit(id, credit);
  }

  @DeleteMapping(path = {"{id}"}, produces = {"application/json"})
  public Mono<ResponseEntity<Void>> deleteById(@PathVariable String id) {
    return creditService.deleteById(id)
      .map(c -> ResponseEntity.ok().<Void>build())
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
