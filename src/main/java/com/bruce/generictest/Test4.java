package com.bruce.generictest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by wuteng1 on 2016/9/7.
 */
public class Test4 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("abc");

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass() == arrayList2.getClass());
        System.out.println("**************************");
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);
        try {
            arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < arrayList3.size(); i++){
            System.out.println(arrayList3.get(i));
        }
    }
}
