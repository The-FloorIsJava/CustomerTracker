package com.revature.CustomerTracker.Model;

import java.util.Objects;

/**
 * a model class that represents com.revature.CustomerTracker.Model.Customer.
 */
public class Customer {
    private int customerId;
    private String customerName;
    private double balance;
    private String password;

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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Double.compare(customer.balance, balance) == 0 && Objects.equals(customerName, customer.customerName) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, balance, password);
    }
}
