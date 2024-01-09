package tom.study.domain.customer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import tom.study.domain.customer.model.entity.Customer;
import tom.study.domain.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createUser(Customer customer) {
        customerRepository.save(customer);
    }
}
