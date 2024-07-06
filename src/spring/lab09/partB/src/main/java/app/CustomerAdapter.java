package app;

import app.dto.CustomerDTO;

public class CustomerAdapter {

    public static CustomerDTO toCustomerDTO(Customer cust){
        return new CustomerDTO(cust.getId(),cust.getName());
    }
}
