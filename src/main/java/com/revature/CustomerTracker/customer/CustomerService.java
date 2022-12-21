package com.revature.CustomerTracker.customer;

import com.revature.CustomerTracker.cartitem.CartItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;
    private Logger logger = LogManager.getLogger();

    @Autowired
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
