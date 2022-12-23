package com.revature.CustomerTracker.customer;

import com.revature.CustomerTracker.Util.Interface.Secured;
import com.revature.CustomerTracker.cartitem.CartItem;
import com.revature.CustomerTracker.Util.DTO.LoginCreds;
import com.revature.CustomerTracker.Util.Exceptions.InvalidCustomerInputException;
import com.revature.CustomerTracker.Util.Tokens.JWTUtility;
import com.revature.CustomerTracker.customer.dto.requests.NewCustomerRequest;
import com.revature.CustomerTracker.customer.dto.responses.CustomerResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin(exposedHeaders = "Authorization")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;
    JWTUtility jwtUtility;

    private Logger logger = LogManager.getLogger();
    @Autowired
    public CustomerController(CustomerService customerService, JWTUtility jwtUtility){
        this.customerService = customerService;
        this.jwtUtility = jwtUtility;
    }

    @GetMapping("/hello")
    public String getCustomerEndpoint(){
        return "Hello from the customer controller";
    }

    @GetMapping
    @Secured(isPlatnium = true)
    public List<CustomerResponse> findAll(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/2")
    public List<CustomerResponse> findAllPart2(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/login")
    public CustomerResponse login(@RequestBody LoginCreds loginCreds, HttpServletResponse resp) throws IOException {
        Customer authCustomer = customerService.login(loginCreds.getCustomerName(), loginCreds.getPassword());
        String token = jwtUtility.createToken(authCustomer);
        resp.setHeader("Authorization", token);
        return new CustomerResponse(authCustomer);
    }

    @PostMapping("/register")
    public CustomerResponse register(@RequestBody @Valid NewCustomerRequest newCustomerRequest){
        return customerService.addCustomer(newCustomerRequest);
    }


    @GetMapping("/{id}")
    public String getId(@PathVariable String id){
        return "The Id provided was: " + id;
    }

    @GetMapping("/findID")
    public String queryId(@RequestParam String ident){
        return "The id provided through the query was: " + ident;
    }


}
