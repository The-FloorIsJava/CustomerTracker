package com.revature.CustomerTracker.customer;

import com.revature.CustomerTracker.Util.Exceptions.InvalidCustomerInputException;
import com.revature.CustomerTracker.cartitem.CartItem;
import com.revature.CustomerTracker.customer.dto.requests.NewCustomerRequest;
import com.revature.CustomerTracker.customer.dto.responses.CustomerResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private Logger logger = LogManager.getLogger();

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

//    overloaded method (method with the same name but different parameters)
    public CustomerResponse addCustomer(NewCustomerRequest newCustomerRequest){
        logger.debug("{} the information prior was sent ot the service", newCustomerRequest);
        Customer customer = new Customer(newCustomerRequest);
        return new CustomerResponse(customerRepository.save(customer));
    }

    public Customer getCustomer(String name){
       return null;
    }

    public void removeCustomer(String name){

    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> getAllCustomers() {
        return ((Collection<Customer>) customerRepository.findAll()).stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    public CartItem makeOrder(CartItem cartItem) {
        return null;
    }

    @Transactional
    public Customer login(String customerName, String password) throws InvalidCustomerInputException{

        return customerRepository.findByCustomerNameAndPassword(customerName, password).orElseThrow(InvalidCustomerInputException::new);
    }


}
