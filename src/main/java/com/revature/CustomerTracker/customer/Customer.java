package com.revature.CustomerTracker.customer;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.CustomerTracker.cartitem.CartItem;
import com.revature.CustomerTracker.customer.dto.requests.NewCustomerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

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

    @Column(name="customer_name", unique = true)
    private String customerName;

    private double balance;

    private String password;

    @Enumerated(EnumType.STRING)
    private  Tier tier = Tier.valueOf("BRONZE");

//    @OneToMany(mappedBy = "owned_by", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Transient
//    private Set<CartItem> cartItemSet;

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

    public Customer(NewCustomerRequest newCustomerRequest){
        this.customerName = newCustomerRequest.getCustomerName();
        this.balance = newCustomerRequest.getBalance();
        this.password = newCustomerRequest.getPassword();
        this.tier = Tier.valueOf(newCustomerRequest.getTier().toUpperCase());
    }

    public enum Tier{
        BRONZE,
        SILVER,
        GOLD,
        PLATNIUM
    }
}
