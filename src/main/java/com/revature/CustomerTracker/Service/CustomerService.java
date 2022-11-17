package com.revature.CustomerTracker.Service;

import com.revature.CustomerTracker.DAO.CustomerDAO;
import com.revature.CustomerTracker.Model.CartItem;
import com.revature.CustomerTracker.Model.Customer;

import java.util.List;

public class CustomerService {

    private Customer sessionCustomer = null;
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

//    overloaded method (method with the same name but different parameters)
    public Customer addCustomer(Customer customer){
        return customerDAO.create(customer);
    }

    public Customer getCustomer(String name){
       return null;
    }

    public void removeCustomer(String name){

    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public CartItem makeOrder(CartItem cartItem) {
        return null;
    }

    public void login(String customerName, String password){
        // TODO: IMPLEMENT ME WITH DAO
        sessionCustomer = customerDAO.loginCheck(customerName, password);
    }

    public void logout(){
        sessionCustomer = null;
    }

    public Customer getSessionCustomer(){
        return sessionCustomer;
    }

}
