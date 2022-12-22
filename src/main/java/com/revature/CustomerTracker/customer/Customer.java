package com.revature.CustomerTracker.customer;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * a model class that represents com.revature.CustomerTracker.customer.Customer.
 */

@Data // this handles is the toString, hashcode, equals and getters and setters
@NoArgsConstructor
//@AllArgsConstructor because we have the Tier Enum that requires a specific action for the Tier enter, we can ignore this annotation

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name")
    private String customerName;

    private double balance;
    @JsonAlias(value = {"pass", "PaSsWoRd"})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private  Tier tier = Tier.valueOf("BRONZE");

    public Customer(String customerName, double balance, String password) {
        this.customerName = customerName;
        this.balance = balance;
        this.password = password;
    }

    public Customer(int customerId, String customerName, double balance, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.password = password;
    }

    public Customer(int customerId, String customerName, double balance, String password, String tier) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.password = password;
        this.tier = Tier.valueOf(tier.toUpperCase());
    }

    public Customer(int customerId, String customerName, String tier) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.tier = Tier.valueOf(tier.toUpperCase());
    }

    private enum Tier{
        BRONZE,
        SILVER,
        GOLD,
        PLATNIUM
    }
}
