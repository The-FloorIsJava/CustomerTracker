package Service;

import Model.CartItem;
import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    List<Customer> customerList;
    List<CartItem> orderList;
    int serialId = 1;

    public CustomerService(){
        customerList = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    public void addCustomer(String name, double balance, String password){
        Customer newCustomer = new Customer(name, balance, password);
        customerList.add(newCustomer);
    }
//    overloaded method (method with the same name but different parameters)
    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public Customer getCustomer(String name){
        for(int i = 0; i < customerList.size(); i++){
            Customer c = customerList.get(i);
            if(c.getCustomerName().equals(name)){
                return customerList.get(i);
            }
        }
        return null;
    }

    public void removeCustomer(String name){
        for(int i = 0; i < customerList.size(); i++){
            Customer c = customerList.get(i);
            if(c.getCustomerName().equals(name)){
                customerList.remove(i);
            }
        }
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public CartItem makeOrder(CartItem cartItem) {
        cartItem.setCartItemId(serialId);
        orderList.add(cartItem);
        serialId++;
        return cartItem;
    }

}
