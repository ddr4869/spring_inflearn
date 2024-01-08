package tom.study.api.usecase.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tom.study.api.controller.customer.model.CustomerCreateRequest;
import tom.study.domain.customer.service.CustomerService;


@Service
@RequiredArgsConstructor
public class WriteCustomerUsecase {

    private final CustomerService customerService;

    public void execute(CustomerCreateRequest customerCreateRequest) {
        customerService.createUser(customerCreateRequest.ModelToEntity(customerCreateRequest));
    }
}
