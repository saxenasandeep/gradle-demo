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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

/**
 * Java Source InterviewTest.java created on Mar 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class InterviewTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testBlockingQueue() {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        final AtomicInteger count = new AtomicInteger(5);

        final Runnable producer = () -> {
            while (count.get() != 0) {
                try {
                    final int number = new Random().nextInt();
                    queue.put(number);
                    count.decrementAndGet();
                    System.out.println("Thread " + Thread.currentThread().getName() + " Produced " + number);
                }
                catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Runnable consumer = () -> {
            while (!queue.isEmpty()) {
                try {
                    final int number = queue.take();
                    System.out.println("Thread " + Thread.currentThread().getName() + " Consumed " + number);
                }
                catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    @Test
    public void testFlatMap() {
        final Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        final List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(phones);

    }

    @Test
    public void testImmutable() {

        A a = new A(1);
        final B b = new B(2);
        log.info("a : {}, b: {}", a.getId(), b.getId());

        b.setId(3);
        a = b;
        log.info("a : {}, b: {}", a.getId(), b.getId());
    }

    @Test
    public void testOptional() {

        String s1 = new String("Hello");
        final Optional<String> sOpt = Optional.of(s1);

        log.info("optional: {}", sOpt.get());

        s1 = null;
        log.info("optional: {}", sOpt.or("default"));
    }

}
