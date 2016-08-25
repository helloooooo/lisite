package com.bruce.design_pattern.chapter9;

/**
 * Created by wuteng1 on 2016/8/1.
 */
public class MenuTestDriver2 {
    public static void main(String[] args) {


        MenuComponent pancakeHouseMenu = new Menu2("pancake house menu", "breakfast");
        MenuComponent dinerMenu = new Menu2("dinner menu", "dinner");
        MenuComponent cafeMenu = new Menu2("cafe menu", "cafe");
        MenuComponent dessertMenu = new Menu2("dessert menu", "dessert");

        MenuComponent allMenus = new Menu2("all menus", "all menus conbined");

        dinerMenu.add(new MenuItem2("dinnerA", "nice", true, .22));
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem2("app pie", "good app pie", true, .11));

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(dessertMenu);
        Waitress2 waitress2 = new Waitress2(allMenus);
        waitress2.printMenu();
    }
}
