package com.bruce.concurrentdemo.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/7/20.
 */
public class SleepUtils {
    public static final void second(long seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
