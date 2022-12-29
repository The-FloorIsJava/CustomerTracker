package com.revature.CustomerTracker.menuitem;

import com.revature.CustomerTracker.Util.Exceptions.InvalidCustomerInputException;
import com.revature.CustomerTracker.customer.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

    MenuItemService menuItemService;
    CustomerService customerService;

    @Autowired
    public MenuItemController(CustomerService customerService){
        this.customerService = customerService;
        menuItemService = new MenuItemService();
    }

    @GetMapping
    public void exInvalidInput(){
        throw new InvalidCustomerInputException("Ha you've activated my trap card!");
    }

}
