package com.revature.CustomerTracker.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * a model class that represents com.revature.CustomerTracker.Model.Customer.
 */
public class Customer {
    private int customerId;
    private String customerName;
    private double balance;
    @JsonAlias(value = {"pass", "PaSsWoRd"})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private  Tier tier = Tier.valueOf("BRONZE");

    public Customer() {
    }

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTier() {
        return tier.toString();
    }

    public void setTier(String tier) {
        this.tier = Tier.valueOf(tier.toUpperCase());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                ", tier=" + tier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Double.compare(customer.balance, balance) == 0 && Objects.equals(customerName, customer.customerName) && Objects.equals(password, customer.password) && tier == customer.tier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, balance, password, tier);
    }

    private enum Tier{
        BRONZE,
        SILVER,
        GOLD,
        PLATNIUM
    }
}
