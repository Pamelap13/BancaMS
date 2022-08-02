package com.nttdata.bancamicroservices.model.repository;

import com.nttdata.bancamicroservices.model.domain.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ICardRepository extends ReactiveCrudRepository<Card, Integer> {
}
