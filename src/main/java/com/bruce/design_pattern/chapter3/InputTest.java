package com.bruce.design_pattern.chapter3;

import java.io.*;

/**
 * Created by wuteng1 on 2016/7/30.
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("demo.txt")));
        int c;
        while((c = is.read()) > 0){
            System.out.print((char) c);
        }
        is.close();
    }
}
