package tom.study.api.controller.customer.model;

import jakarta.validation.constraints.NotEmpty;
import tom.study.domain.customer.model.entity.Customer;

public class CustomerCreateRequest {

    @NotEmpty
    private String customerName;
    @NotEmpty
    private String customerPw;
    @NotEmpty
    private String customerEmail;
    @NotEmpty
    private String  customerTel;
    @NotEmpty
    private String  customerPostcode;
    @NotEmpty
    private String  customerAddress;
    @NotEmpty
    private String  customerDetailAddress;
    @NotEmpty
    private String  customerGrade;
    @NotEmpty
    private String  customerExtraAddress;
    @NotEmpty
    private String  customerDelete;


    public Customer ModelToEntity(CustomerCreateRequest customerCreateRequest) {
        Customer customerEntity = new Customer();
        customerEntity.setCustomerName(customerCreateRequest.customerName);
        customerEntity.setCustomerPw(customerCreateRequest.customerPw);
        customerEntity.setCustomerEmail(customerCreateRequest.customerEmail);
        customerEntity.setCustomerTel(customerCreateRequest.customerTel);
        customerEntity.setCustomerPostcode(customerCreateRequest.customerPostcode);
        customerEntity.setCustomerAddress(customerCreateRequest.customerAddress);
        customerEntity.setCustomerDetailAddress(customerCreateRequest.customerDetailAddress);
        customerEntity.setCustomerGrade(customerCreateRequest.customerGrade);
        customerEntity.setCustomerExtraAddress(customerCreateRequest.customerExtraAddress);
        customerEntity.setCustomerDelete(customerCreateRequest.customerDelete);
        return customerEntity;
    }
}
