package com.revature.CustomerTracker.menuitem;

import com.revature.CustomerTracker.menuitem.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuItemService {

    List<MenuItem> menuItemList;

    public MenuItemService(){
        menuItemList = new ArrayList<>();
    }

    public void addCMenuItem(String name, double balance){
        MenuItem newMenuItem = new MenuItem(name, balance);
        menuItemList.add(newMenuItem);
    }
    //    overloaded method (method with the same name but different parameters)
    public void addCustomer(MenuItem customer){
        menuItemList.add(customer);
    }

    public MenuItem getMenuItem(String name){
        for(int i = 0; i < menuItemList.size(); i++){
            MenuItem c = menuItemList.get(i);
            if(c.getItemName().equals(name)){
                return menuItemList.get(i);
            }
        }
        return null;
    }

    public void removeMenuItem(String name){
        for(int i = 0; i < menuItemList.size(); i++){
            MenuItem c = menuItemList.get(i);
            if(c.getItemName().equals(name)){
                menuItemList.remove(i);
            }
        }
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemList;
    }

}