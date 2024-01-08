package tom.study.domain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tom.study.domain.customer.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerName(String customerName);
}
