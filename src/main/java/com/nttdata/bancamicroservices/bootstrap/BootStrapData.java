package com.nttdata.bancamicroservices.bootstrap;

import com.nttdata.bancamicroservices.model.repository.IAccountRepository;
import com.nttdata.bancamicroservices.model.repository.ICreditRepository;
import com.nttdata.bancamicroservices.model.repository.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;

/**
 * Data repositorios.
 */
public class BootStrapData implements CommandLineRunner {

  private final ICustomerRepository customerRepository;
  private final IAccountRepository accountRepository;
  private final ICreditRepository creditRepository;

  public BootStrapData(ICustomerRepository iCustomerRepository,
                       IAccountRepository iAccountRepository, ICreditRepository iCreditRepository) {
    this.customerRepository = iCustomerRepository;
    this.accountRepository = iAccountRepository;
    this.creditRepository = iCreditRepository;
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
