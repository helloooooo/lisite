package com.bruce.designpattern.decorator;

import java.io.*;

/**
 * Created by wuteng1 on 2016/6/8.
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/test.txt")));
            while((c=in.read()) >= 0){
                System.out.print((char)c);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
