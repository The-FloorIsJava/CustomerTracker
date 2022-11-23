package com.revature.CustomerTracker;

import com.revature.CustomerTracker.Controller.CustomerController;
import com.revature.CustomerTracker.Controller.MenuItemController;
import com.revature.CustomerTracker.DAO.CustomerDAO;
import com.revature.CustomerTracker.Service.CustomerService;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);
        CustomerService customerService = new CustomerService(new CustomerDAO());


        new CustomerController(app, customerService).customerEndpoint();
        MenuItemController menuItemController = new MenuItemController(customerService);

        menuItemController.menuItemEndpoint(app);
    }
}
