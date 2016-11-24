package com.bruce.exception_demo;

import org.junit.Test;

/**
 * Created by wuteng1 on 2016/9/21.
 */
public class ExceptionDemo {
    private Integer calc(Integer a, Integer b){
        Integer res = a/b;
        String s = "{\"4767\":\"{\\\"delivery_id\\\":4767,\\\"tabs\\\":[{\\\"tab_id\\\":2699,\\\"category_info\\\":\\\"null\\\",\\\"brand_info\\\":\\\"[29668, 23960, 47601, 36448, 29311, 111297, 118466, 56083, 53406, 59885, 48058, 50209, 60979, 33775, 16076, 17570, 68223, 122798, 17199]\\\",\\\"start_time\\\":\\\"2016-05-19 00:00:00.0\\\",\\\"end_time\\\":\\\"2018-04-30 00:00:00.0\\\"}]}\"}";
        System.out.println(s);
        return res;
    }

    @Test
    public void testThrow(){
        System.out.println(calc(2,1));
    }
}
