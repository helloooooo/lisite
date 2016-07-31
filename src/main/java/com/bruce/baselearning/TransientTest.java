package com.bruce.baselearning;

import java.io.*;

/**
 * Created by wuteng1 on 2016/7/22.
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Alexa");
        user.setPasswd("123");

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) is.readObject();
            is.close();
            System.out.println(user.getUsername());
            System.out.println(user.getPasswd());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable{
    private static final long serialVersionUID = -1;
    private String username;
    private transient String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}