package com.revature.CustomerTracker.Service;

import com.revature.CustomerTracker.DAO.CustomerDAO;
import com.revature.CustomerTracker.Model.CartItem;
import com.revature.CustomerTracker.Model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;
    private Logger logger = LogManager.getLogger();

    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

//    overloaded method (method with the same name but different parameters)
    public Customer addCustomer(Customer customer){
        logger.debug("{} the information prior was sent ot the service", customer);
        return customerDAO.create(customer);
    }

    public Customer getCustomer(String name){
       return null;
    }

    public void removeCustomer(String name){

    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public CartItem makeOrder(CartItem cartItem) {
        return null;
    }

    public Customer login(String customerName, String password){
        // TODO: IMPLEMENT ME WITH DAO
        return customerDAO.loginCheck(customerName, password);
    }


}
