package com.bruce.enum_demo;

import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created by 腾 on 2016/7/10.
 */
public class EnumTest {

    enum Mobile{
        Samsung(400), Nokia(250), Motorola(325);
        int price;
        Mobile(int p){
            price = p;
        }
        int showPrice(){
            return price;
        }
        public final String lowerName = this.name().toLowerCase();


    }

    @Test
    public void testMobile(){
        for(Mobile m: Mobile.values()){
            System.out.println(m.name());
        }

    }

    enum Light{
        RED(1),YELLOW(2),GREEN(3);
        private int code;

        Light(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return String.valueOf(this.code);
        }
    }

    public static void main(String[] args) {
        testTraversal();
//        testEnumMap();
//        testEnumSet();
    }
    private static void testTraversal(){
        for(Light light: Light.values()){
            System.out.println(light.name());
            System.out.println(light.ordinal());
            System.out.println(light);
        }
    }

    private static  void testEnumSet(){
        EnumSet<Light> lightSet = EnumSet.allOf(Light.class);
        for(Light light: lightSet){
            System.out.println(light);
        }
    }
    private static void testEnumMap(){
        EnumMap<Light,String> currEnumMap = new EnumMap<Light, String>(Light.class);
        currEnumMap.put(Light.GREEN, "绿灯");
        currEnumMap.put(Light.YELLOW, "黄灯");
        currEnumMap.put(Light.RED, "红灯");

        for(Light light: Light.values()){
            System.out.println(light.name() + "--->" + currEnumMap.get(light));

        }
    }
}
