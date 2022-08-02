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
    if (validateCredit(credit)) {
      log.info("validar " + HttpStatus.OK);
      return creditRepository.save(credit);
    } else {
      return null;
    }
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

   * @param credit Clase creditosS
   * @return validate
   */
  private boolean validateCredit(Credit credit) {
    boolean validate = true;
    log.info(credit.toString());
    log.info(credit.getCreditType().toString());
    if (credit.getCreditType().equals(CreditType.ENTERPRISE)) {
      validate = true;
    } else if (credit.getCreditType().equals(CreditType.PERSONAL)) {
      creditRepository.findAll()
        .any(c -> c.getCustomerId().equals(credit.getCustomerId()))
          .then(Mono.just(validate = false));
    }
    return validate;
  }


}
