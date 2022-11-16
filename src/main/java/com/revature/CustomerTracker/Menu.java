package com.revature.CustomerTracker;

import com.revature.CustomerTracker.Model.Customer;
import com.revature.CustomerTracker.Service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    //let's say we have some employee that is very very meticulous
//    and will input into our CLI every time a customer enters or leaves the store
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        boolean active = true;
        Scanner userInput = new Scanner(System.in);
        while(active){
            System.out.println("Options: \n1: add customer \n2: get customer by name \n3: remove customer by name \n4: display all customers");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if(choice == 1){
                System.out.println("input the name:");
                String newName = userInput.nextLine();
                System.out.println("input the balance:");
                double newCash = userInput.nextDouble();
                userInput.nextLine();
                customerService.addCustomer(newName, newCash);
            }else if(choice == 2){
                System.out.println("input the name:");
                String newName = userInput.nextLine();
                Customer customer = customerService.getCustomer(newName);
                System.out.println(customer);
            }else if(choice == 3){
                System.out.println("input the name:");
                String newName = userInput.nextLine();
                customerService.removeCustomer(newName);
            }else if(choice == 4){
                List<Customer> allCustomers = customerService.getAllCustomers();
                System.out.println(allCustomers);
            }
        }
    }
}
