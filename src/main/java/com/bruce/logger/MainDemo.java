package com.bruce.logger;

import org.apache.log4j.Logger;

/**
 * Created by wuteng1 on 2016/5/11.
 */
public class MainDemo {
    private static Logger logger = Logger.getLogger(MainDemo.class);
    public static void main(String[] args) {
        logger.debug("This is debug message.");
        logger.info("This is info message");
        logger.error("This is error message");
        System.out.println("hello, world");
    }
}
