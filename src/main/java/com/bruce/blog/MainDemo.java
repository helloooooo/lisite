package com.bruce.blog;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuteng1 on 2016/7/19.
 */
public class MainDemo {
    public static void main(String[] args) {
        try {
            String a = FileUtils.readFileToString(new File("user.txt"), "utf-8");
            String[] lines = a.split("\n");
            for(String line1: lines){
                String[] line = line1.split("\\s+", 2);
                StringBuffer sb = new StringBuffer();
                sb.append("insert into rktsr.user_features(user_id, features) values('" + line[0] + "','" + line[1] + "');\n");
                FileUtils.write(new File("userProfile.cql"), sb.toString(), true);
            }

            String b = FileUtils.readFileToString(new File("sku.txt"), "utf-8");
            String[] lines2 = b.split("\n");
            for(String line1: lines2){
                String[] line = line1.split("\\s+", 2);
                StringBuffer sb = new StringBuffer();
                sb.append("insert into rktsr.sku_features(sku_id, features) values(" + line[0] + ",'" + line[1] + "');\n");
                FileUtils.write(new File("skuProfile.cql"), sb.toString(), true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
