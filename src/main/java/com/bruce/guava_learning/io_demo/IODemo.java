package com.bruce.guava_learning.io_demo;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuteng1 on 2016/9/18.
 */
public class IODemo {
    @Test
    public void testFileIO() throws IOException {
        String fileName = "test.txt";
        File file = new File(fileName);

        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();


        Multiset<String> wordOccurrences = HashMultiset.create(
                Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings().split(Files.asCharSource(file, Charsets.UTF_8).read()));
    }
}
