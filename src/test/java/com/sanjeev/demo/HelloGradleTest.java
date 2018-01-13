/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */
package com.sanjeev.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

/**
 * 
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @date : Oct 28, 2017
 * 
 */

public class HelloGradleTest {

    @Test
    public void test() {
        org.junit.Assert.assertTrue("Result must not be null", true);
    }

    @Test
    public void testExample() {

        List<String> list = new ArrayList<>();

        list.add("sanjeev");

        list = null;

        System.out.println(Optional.ofNullable(list).orElse(Arrays.asList(new String[] { "hello world" })));

    }

}
