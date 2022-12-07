package com.revature.CustomerTracker;

import com.revature.CustomerTracker.Controller.CustomerController;
import com.revature.CustomerTracker.Controller.MenuItemController;
import com.revature.CustomerTracker.DAO.CustomerDAO;
import com.revature.CustomerTracker.Service.CustomerService;
import com.revature.CustomerTracker.Util.Tokens.JWTUtility;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
                    config.plugins.enableCors(cors ->{
                        cors.add(it -> {
                            it.anyHost();
                            it.exposeHeader("Authorization");
                        });
                    });
                }

        ).start(8080);

        JWTUtility jwtUtility = new JWTUtility();
        CustomerService customerService = new CustomerService(new CustomerDAO());


        new CustomerController(app, customerService, jwtUtility).customerEndpoint();
        MenuItemController menuItemController = new MenuItemController(customerService);

        menuItemController.menuItemEndpoint(app);
    }
}
