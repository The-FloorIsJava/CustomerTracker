package com.revature.CustomerTracker.Model;

import java.util.Objects;

public class MenuItem {
    private int menuItemId;
    private String itemName;
    private double price;

    public MenuItem() {
    }

    public MenuItem(int menuItemId, String itemName, double price) {
        this.menuItemId = menuItemId;
        this.itemName = itemName;
        this.price = price;
    }

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemId=" + menuItemId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return menuItemId == menuItem.menuItemId && Double.compare(menuItem.price, price) == 0 && Objects.equals(itemName, menuItem.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItemId, itemName, price);
    }
}
