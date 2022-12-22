package com.revature.CustomerTracker.customer.dto.requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerRequest {
    private String customerName;
    private double balance;

    @JsonAlias(value = {"Pass", "PaSsWoRd"})
    private String password;
    private String tier;
}
