package com.revature.CustomerTracker.customer.dto.responses;

import com.revature.CustomerTracker.customer.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerResponse {

    private int customerId;
    private String customerName;
    private double balance;
    private String tier;

    public CustomerResponse(Customer customer){
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.balance = customer.getBalance();
        this.tier = String.valueOf(customer.getTier());
    }

}
