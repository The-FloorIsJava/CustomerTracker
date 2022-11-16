package com.revature.CustomerTracker.Controller;

import com.revature.CustomerTracker.Model.CartItem;
import com.revature.CustomerTracker.Model.Customer;
import com.revature.CustomerTracker.Service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class CustomerController {
    CustomerService customerService;
    Javalin app;
    public CustomerController(Javalin app){
        customerService = new CustomerService();
        this.app = app;
    }
    public void customerEndpoint(){

        /*
        app.[http verb]([url endpoint after localhost:8080], this::[handler method]);

        http verbs:
        get (retrieve some representations)
        post (persist some representations that is contained within a body)
        put (update a model representation)
        patch (update a part of a representation)
        delete (delete some representation)

        url endpoint: ex, localhost:8080/endpoint

        handler method: a method we write in this class which will be passed the Javalin context for us to use,
        which can hold information about the web request that was made, and can also generate a response.
         */
        app.get("hello", this::helloHandler);
        app.post("customer",this::postCustomerHandler);
        app.get("customer", this::getAllCustomersHandler);
        app.get("customer/{name}",this::getSpecificCustomerHandler);
        app.post("customer/order", this::postOrderHandler);
    }

    /**
     * use the javalin context to retrieve a String from the path.
     * use the customerService to retrieve a specific customer and return it as JSON.
     * @param context
     */
    private void getSpecificCustomerHandler(Context context) {
        String name = context.pathParam("name");
        Customer customer = customerService.getCustomer(name);
        context.json(customer);
    }

    /**
     * use the javalin context to return a JSON representation of the list of all customers which
     * we have received from the CustomerService.
     * @param context
     */
    private void getAllCustomersHandler(Context context) {
        List<Customer> allCustomers = customerService.getAllCustomers();
//        similar as context.result, but the content type is json rather than text.
        context.json(allCustomers);
    }

    /**
     * receive a JSON representation of a Customer in the body of an HTTP request.
     * that representation should be converted into a Java object and saved to the CustomerService.
     * @param context
     */
    private void postCustomerHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(context.body(), Customer.class);
        customerService.addCustomer(customer);
        context.json(customer);
    }

    /**
     * receives a JSON representation of a CartItem for a users order though the body of a HTTP request.
     * That representation should be converted into the Java object and saved into the orderList inside the CustomerService
     * @param context
     * @throws JsonProcessingException
     */
    private void postOrderHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CartItem cartItem = mapper.readValue(context.body(), CartItem.class);
        CartItem orderedItem = customerService.makeOrder(cartItem);
        context.json(orderedItem);
    }

    public void helloHandler(Context ctx){
        ctx.result("hello world");
    }
}
