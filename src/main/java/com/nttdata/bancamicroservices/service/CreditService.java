package com.nttdata.bancamicroservices.service;

import com.nttdata.bancamicroservices.model.domain.Credit;
import com.nttdata.bancamicroservices.model.domain.type.CreditType;
import com.nttdata.bancamicroservices.model.interfaces.ICreditService;
import com.nttdata.bancamicroservices.model.repository.ICreditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;

/**
 * Servicio operacional de creditos.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreditService implements ICreditService {

  @Autowired
  private final ICreditRepository creditRepository;

  @Override
  public Flux<Credit> getAllCredits() {
    return creditRepository.findAll();
  }

  @Override
  public Mono<Credit> findById(String id) {
    return creditRepository.findById(id);
  }

  @Override
  public Mono<Credit> createCredit(Credit credit) {
  return validateCredit(credit).
            flatMap(value ->{
              if(!value){
                return creditRepository.save(credit);
              }
              else {
                log.info("Cliente ya cuenta con un credito personal" + HttpStatus.CONTINUE);
                return Mono.empty();
              }
            });
  }

  @Override
  public Mono<ResponseEntity<Credit>> updateCredit(String id, Credit credit) {
    return creditRepository.findById(id)
      .flatMap(oldCredit -> {
        oldCredit.setLimitCredit(credit.getLimitCredit());
        oldCredit.setBalance(credit.getBalance());
        oldCredit.setCreditType(credit.getCreditType());
        return  creditRepository.save(oldCredit);
      })
      .map(updateCredit -> new ResponseEntity<>(updateCredit, HttpStatus.OK));
  }

  @Override
  public Mono<Credit> deleteById(String id) {
    return creditRepository.findById(id)
      .flatMap(deleteCredit -> creditRepository.delete(deleteCredit)
        .then(Mono.just(deleteCredit)));
  }

  /**
   * Validacion de Creditos.

   * @param credit Clase creditos
   * @return validate
   */
  private Mono<Boolean> validateCredit(Credit credit) {
    Mono<Boolean> exits = Mono.just(true);
    if (credit.getCreditType().equals(CreditType.PERSONAL)){
      exits = creditRepository.findAll()
        .any(c-> c.getCustomerId().equals(credit.getCustomerId()))
        .switchIfEmpty(Mono.just(false));
    }
    return exits;
  }
}