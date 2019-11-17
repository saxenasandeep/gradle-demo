/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.demo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sanjeev.gradledemo.dto.Counter;
import com.sanjeev.gradledemo.dto.Employee;

/**
 * Java Source PracticeTest.java created on Apr 17, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class PracticeTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    double dd;

    @Test
    public void testASCIICode() {
        System.out.println(Integer.valueOf("v".charAt(0)));
    }

    // @Ignore
    @Test
    public void testBlockingQueue() {
        final BlockingQueue<Employee> bQueue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {

            final Employee e = new Employee(new Random().nextInt(), "a");
            try {
                bQueue.put(e);
            }
            catch (final InterruptedException e1) {
                e1.printStackTrace();
            }
            log.info("{} produced {}", Thread.currentThread().getName(), e);

        };

        final Runnable consumer = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                final Employee e = bQueue.take();
                log.info("{} consumed {}", Thread.currentThread().getName(), e);

            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };

        final ExecutorService execSvc = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            execSvc.execute(new Thread(producer));
        }

        final ExecutorService execSvc1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 5; i++) {
            execSvc1.execute(new Thread(consumer));
        }

        execSvc.shutdown();
        execSvc1.shutdown();

        while (!execSvc.isTerminated()) {
        }

        while (!execSvc1.isTerminated()) {
        }
    }

    @Test
    public void testCharOccurenceCount() {
        final String str = "abcaaebcc";
        final String a[] = new String[str.length()];

        String unique = new String();
        for (int i = 0; i < str.length(); i++) {
            final String currentChar = Character.valueOf(str.charAt(i)).toString();
            if (!unique.contains(currentChar)) {
                unique = unique + currentChar;
            }
        }

        log.info("unique chars, i/p {}, o/p {}", str, unique);
        a[0] = unique;

        for (int i = 1; i < str.length(); i++) {
            a[i] = "";
        }

        for (int i = 0; i < str.length(); i++) {
            final String currentChar = Character.valueOf(str.charAt(i)).toString();
            log.info("currentChar {}", currentChar);
            for (int j = 0; j < a.length; j++) {
                if (a[j].contains(currentChar)) {
                    final String temp = a[j].replace(currentChar, "");
                    log.info("match found in array, removed current char {}, o/p {}", currentChar, temp);
                    a[j] = temp;
                    a[j + 1] = a[j + 1] + currentChar;

                    log.info("current array {}", Arrays.asList(a));
                    break;
                }
            }
        }

        log.info("result {}", Arrays.asList(a));

    }

    @Test
    public void testClone() throws CloneNotSupportedException {

        final Counter count = new Counter();
        count.setCount(1);
        final Employee emp = new Employee();
        emp.setEmpId(100);
        emp.setName("Angela");
        count.setEmp(emp);

        log.info("c1 {}", count);

        final Counter c2 = count.copy();
        c2.setCount(2);
        c2.getEmp().setName("Hung");

        log.info("c2 {}", c2);
        log.info("c1 {}", count);
    }

    @Test
    public void testErrors() {
        try {
            throw new Error("");
        }
        catch (final Error err) {
            log.info("Error", err);
        }
        log.info("Good to go after Error");
    }

    @Test
    public void testIntegerMatch() {

        // returns true
        Integer a = 127;
        Integer b = 127;

        Assert.assertEquals(true, a == b);

        // returns false
        a = 1000;
        b = 1000;
        Assert.assertEquals(false, a == b);

        // primitive comparison wins
        // final int i = 1000;
        // final int j = 1000;
        // Assert.assertEquals(true, i == j);
    }

    @Test
    public void testJoin() throws InterruptedException {

        final Thread t1 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread t2 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread t3 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.setName("t3");
        t3.start();

        t2.setName("t2");
        t2.start();

        t1.setName("t1");
        t1.start();

        t3.join();

        t2.join();

        t1.join();
    }

    @Ignore
    @Test
    public void testLocks() {

        final Lock lock = new ReentrantLock();
        final Counter count = new Counter();

        final Runnable task = () -> {
            try {
                log.info("Thread {}, Trying for lock", Thread.currentThread().getName());
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    try {
                        final int tt = count.getCount() + 1;
                        count.setCount(tt);
                        log.info("Thread {}, Acquired, count {}", Thread.currentThread().getName(), count.getCount());
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else {
                    log.info("Thread {}, Not Acquired, count {}", Thread.currentThread().getName(), count.getCount());
                }
            }
            catch (final InterruptedException e) {
                log.error("Error ", e);
            }
        };

        final ExecutorService eSvc = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            eSvc.execute(new Thread(task));
        }

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }
    }

    @Test
    public void testLRUCache() {

        final BlockingQueue<Employee> queue = new ArrayBlockingQueue<>(3);
        queue.add(new Employee(1, "A"));
        queue.add(new Employee(2, "B"));
        queue.add(new Employee(3, "C"));

        queue.offer(new Employee(4, "D"));

        final int a = 925 % 50;
        log.info("Mod {}", a);
        log.info("Queue {}", queue);
    }

    @Test
    public void testNullReferenceOverriding() {
        final ExtendedImmutableClass ext = new ExtendedImmutableClass(123);
        final Object aa = null;
        ext.printVal(aa);
    }

    @Test
    public void testNumbers() {
        final BigDecimal a = new BigDecimal(1.2);
        final BigDecimal b = new BigDecimal(0.4);
        a.setScale(2, RoundingMode.UP);
        log.info("a+b = {}", a.add(b, MathContext.DECIMAL64));
    }

    @Test
    public void testPriorityQueue() {
        final PriorityBlockingQueue<String> qq = new PriorityBlockingQueue<>();

        qq.put("zzzz");
        qq.put("qqq");
        qq.put("aaa");
        qq.put("bbb");

        log.info("qq {}", qq);

    }

    @Ignore
    @Test
    public void testProducerConsumer() {

        final Counter count = new Counter();
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        count.setEnable(false);

        final Runnable r1 = () -> {

            while (count.isEnable()) {
                try {
                    log.info("{}, trying lock", Thread.currentThread().getName());
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        try {
                            log.info("{}, lock acquired", Thread.currentThread().getName());
                            if (count.getCount() == 0) {
                                log.info("{}, incrementing count", Thread.currentThread().getName());
                                final int tt = count.getCount() + 1;
                                count.setCount(tt);

                                TimeUnit.SECONDS.sleep(3);
                                condition.signal();
                            }
                            else {
                                log.info("{}, count not ZERO, waiting", Thread.currentThread().getName());
                                condition.await(5, TimeUnit.SECONDS);
                            }
                        }
                        finally {
                            lock.unlock();
                            log.info("{}, lock released", Thread.currentThread().getName());
                        }
                    }
                    else {
                        log.info("{}, lock acquire failed", Thread.currentThread().getName());
                    }
                }
                catch (final InterruptedException e) {
                    log.error("Error", e);
                }
            }
        };

        final Runnable r2 = () -> {

            while (count.isEnable()) {
                try {
                    log.info("{}, trying lock", Thread.currentThread().getName());
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        try {
                            log.info("{}, lock acquired", Thread.currentThread().getName());
                            if (count.getCount() == 1) {
                                log.info("{}, decrememting count", Thread.currentThread().getName());
                                final int tt = count.getCount() - 1;
                                count.setCount(tt);

                                TimeUnit.SECONDS.sleep(3);
                                condition.signal();
                            }
                            else {
                                log.info("{}, count ZERO, waiting", Thread.currentThread().getName());
                                condition.await(5, TimeUnit.SECONDS);
                            }
                        }
                        finally {
                            lock.unlock();
                            log.info("{}, lock released", Thread.currentThread().getName());
                        }
                    }
                    else {
                        log.info("{}, lock acquire failed", Thread.currentThread().getName());
                    }
                }
                catch (final InterruptedException e) {
                    log.error("Error", e);
                }
            }
        };

        final ExecutorService eSvc = Executors.newWorkStealingPool();

        eSvc.execute(new Thread(r1));
        eSvc.execute(new Thread(r2));

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }
    }

    @Test
    public void testStreamExample() {
        final List<Employee> employees = new CopyOnWriteArrayList<>();

        employees.add(new Employee(3, "A"));
        employees.add(new Employee(1, "B"));
        employees.add(new Employee(2, "C"));

        log.info("all emps: {}", employees);
        for (final Employee employee : employees) {
            log.info("e {}", employee);
            employees.add(new Employee(4, "D"));
        }

        final Comparator<Employee> byName = (e1, e2) -> {
            return e1.getName().compareTo(e2.getName());
        };

        log.info("Sum {}", employees.parallelStream().mapToInt(zz -> zz.getEmpId()).sum());

        Collections.sort(employees, byName);
        log.info("After SORT, empList: {}", employees);
    }

    @Test
    public void testVolatile() {

        final Counter cc = new Counter();
        final Employee e1 = new Employee(1, "a");
        cc.setEmp(e1);

        log.info("cc init {}", cc);

        final Runnable r1 = () -> {
            cc.m1();
            cc.getEmp().setName("b");
            log.info("r1 cc {}", cc);
        };

        final Runnable r2 = () -> {
            // cc.m2();
            // cc.getEmp().setName("c");
            log.info("r2 cc {}", cc);
        };

        final ExecutorService eSvc = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            eSvc.execute(r1);
            eSvc.execute(r2);
        }

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }

    }

}
