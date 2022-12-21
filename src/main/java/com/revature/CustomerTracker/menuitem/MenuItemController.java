package com.revature.CustomerTracker.menuitem;

import com.revature.CustomerTracker.customer.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MenuItemController {

    MenuItemService menuItemService;
    CustomerService customerService;
    public MenuItemController(CustomerService customerService){
        this.customerService = customerService;
        menuItemService = new MenuItemService();
    }
}
