package com.nttdata.bancamicroservices.service;


import com.nttdata.bancamicroservices.model.domain.Customer;
import com.nttdata.bancamicroservices.model.domain.type.CustomerType;
import com.nttdata.bancamicroservices.model.repository.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class CustomerServiceTest {


  ICustomerRepository customerRepository = Mockito.mock(ICustomerRepository.class);

  @Autowired
  CustomerService customerService = new CustomerService(customerRepository);

  @Test
  void getAllCustomer() {
    customerService.getAllCustomer();
  }
  @Test
  void createCustomer(){
    Customer mockCustomer = new Customer();
    mockCustomer.setCustomerId("0001");
    mockCustomer.setCustomerType(CustomerType.ENTERPRISE);
    mockCustomer.setLastName("Pachas");
    mockCustomer.setFirstName("Pamela");
    mockCustomer.setAge(31);
    mockCustomer.setDni("47045090");

    customerService.createCustomer(mockCustomer);
}

}
