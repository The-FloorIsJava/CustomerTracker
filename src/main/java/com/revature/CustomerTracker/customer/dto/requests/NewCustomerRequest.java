package com.revature.CustomerTracker.customer.dto.requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerRequest {

    @NotNull
    @NotBlank
    private String customerName;

    @Min(value = 0)
    @Max(value = 1000)
    private double balance;

    @JsonAlias(value = {"Pass", "PaSsWoRd"})
    @Pattern(message = "Minimum eight characters, at least one letter, one number and one special character:", regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
    private String tier;
}
