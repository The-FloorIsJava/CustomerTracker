package com.revature.CustomerTracker.menuitem;

import com.revature.CustomerTracker.menuitem.MenuItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;
    public MenuItemService(){

    }

    public void addCMenuItem(String name, double balance){
        MenuItem newMenuItem = new MenuItem(name, balance);
    }
    //    overloaded method (method with the same name but different parameters)
    public void addCustomer(MenuItem customer){

    }

    public MenuItem getMenuItem(String name){
       return null;
    }

    public List<MenuItem> getAllMenuItems() {
        return null;
    }

}
