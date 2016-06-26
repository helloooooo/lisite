package com.bruce.encodingdemo;

import com.sun.jersey.core.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wuteng1 on 2016/6/23.
 */
public class TestMD {
    public static void main(String[] args) {
        String username = "Vicky";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(username.getBytes());
            //String usernameMD5 = messageDigest.digest().toString();
            //System.out.println(usernameMD5);
            System.out.println(Base64.encode(messageDigest.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
