package com.bruce.jsondemo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by wuteng1 on 2016/5/12.
 */
public class JsonMain {
    public static void main(String[] args) {
        String jsonStr = "{\"id\":\"222\",\"direct_id\":\"coupon\",\"business_id\":\"6785_c\",\"floor_id\":null,\"floor_name\":null,\"sort_num\":null,\"category_id\":null,\"category_name\":null,\"sec_category_id\":null,\"sec_category_name\":null,\"delivery_type\":\"2\",\"selected_count\":null,\"ext\":null,\"status\":\"-1\",\"operator\":\"wangjingang3\",\"created\":\"2016-04-27 17:38:32.0\",\"modified\":\"2016-04-29 08:34:48.0\",\"dp\":null,\"dt\":null,\"end_date\":null}";
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(jsonStr).getAsJsonObject();
        JsonElement ele = object.get("selected_count");
        String id = object.get("id").getAsString();
        System.out.println(Integer.parseInt(id));
        System.out.println(ele.toString().equals("null"));
        System.out.println("----------");
        Integer a = null;
        System.out.println(a != 1);
    }
}
