/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Java Source InterviewTest.java created on Mar 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

// @RunWith(JMockit.class)
public class InterviewTest {

    @Test
    public void test() {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(phones);

    }

    @Test
    public void testBlockingQueue() {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Runnable producer = () -> {
            while (true) {
                try {
                    int number = new Random().nextInt();
                    queue.put(number);
                    System.out.println("Thread " + Thread.currentThread().getName() + " Produced " + number);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    int number = queue.take();
                    System.out.println("Thread " + Thread.currentThread().getName() + " Consumed " + number);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
