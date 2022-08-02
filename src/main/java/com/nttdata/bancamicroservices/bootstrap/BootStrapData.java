package com.nttdata.bancamicroservices.bootstrap;

import com.nttdata.bancamicroservices.model.repository.IAccountRepository;
import com.nttdata.bancamicroservices.model.repository.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private final ICustomerRepository ICustomerRepository;
    private final IAccountRepository IAccountRepository;

    public BootStrapData(ICustomerRepository ICustomerRepository, IAccountRepository IAccountRepository) {
        this.ICustomerRepository = ICustomerRepository;
        this.IAccountRepository = IAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
