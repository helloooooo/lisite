package com.bruce.guava_learning;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * Created by wuteng1 on 2016/9/1.
 */
public class ImutableCollection {
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue", "blue"
    );
    @Test
    public void testAsList(){
        System.out.println(COLOR_NAMES.asList());
    }
}
