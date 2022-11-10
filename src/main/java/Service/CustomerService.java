package Service;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    List<Customer> customerList;

    public CustomerService(){
        customerList = new ArrayList<>();
    }

    public void addCustomer(String name, double balance){
        Customer newCustomer = new Customer(name, balance);
        customerList.add(newCustomer);
    }

    public Customer getCustomer(String name){
        for(int i = 0; i < customerList.size(); i++){
            Customer c = customerList.get(i);
            if(c.name.equals(name)){
                return customerList.get(i);
            }
        }
        return null;
    }

    public void removeCustomer(String name){
        for(int i = 0; i < customerList.size(); i++){
            Customer c = customerList.get(i);
            if(c.name.equals(name)){
                customerList.remove(i);
            }
        }
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }
}
