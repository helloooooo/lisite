package com.bruce.guava_learning.string_demo;

import com.google.common.base.*;
import org.junit.Test;

/**
 * Created by wuteng1 on 2016/9/18.
 */
public class StringDemo {
    @Test
    public void testJoin(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Edware"));
    }

    @Test
    public void testSplit(){
        System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split("foo, bar,,, qux"));
    }

    @Test
    public void testCharMatcher(){
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom("\rabc\n");
        System.out.println(noControl);
        String theDigits = CharMatcher.DIGIT.removeFrom("abc123lfsjf");
        System.out.println(theDigits);

        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom("a      c        d ", '*');
        System.out.println(spaced);

        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("abcAAA122FDSFfsfd");
        System.out.println("lowerAndDigit = " + lowerAndDigit);

        String a = "abc";
        byte[] bytes = a.getBytes(Charsets.UTF_8);
        System.out.println(bytes);

        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME"));
    }

}
