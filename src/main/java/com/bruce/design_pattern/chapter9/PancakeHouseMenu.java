package com.bruce.design_pattern.chapter9;

import java.util.ArrayList;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("Name-A", "Des-A", true, .22);
        addItem("Name-B", "Des-B", true, .43);
        addItem("Name-C", "Des-C", true, .34);
        addItem("Name-D", "Des-D", true, .20);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }
}
