/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.demo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Source SampleTests.java created on Jan 28, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class SampleTests {

    @Ignore
    @Test
    public void testDivisor() {
        // Scanner
        final Scanner s = new Scanner(System.in);
        final int totalNums = Integer.valueOf(s.nextLine());

        for (int k = 0; k < totalNums; k++) {
            final int n = Integer.valueOf(s.nextLine());
            System.out.println("Current Num : " + n);
            final List<Integer> divisors = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                }
            }

            System.out.println("divisor list : " + divisors);
            int sum = 0;
            for (final int i : divisors) {
                sum = sum + i;
            }

            System.out.println("sum : " + sum);
            if (sum == n) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }

    @Ignore
    @Test
    public void testLog() {
        // Scanner
        final Scanner s = new Scanner(System.in);
        final int totalNums = Integer.valueOf(s.nextLine());
        final double log2 = Math.log(2);
        for (int i = 0; i < totalNums; i++) {

            final String[] line = s.nextLine().split(" ");
            final int C = Integer.valueOf(line[0]);
            final int S = Integer.valueOf(line[1]);

            double currentSweetnes = 0.0d;

            for (int j = 1; j < S; j++) {

                currentSweetnes = C * j * Math.sqrt(Double.valueOf(j)) * Math.log(j) / log2;
                System.out.println(
                        MessageFormat.format("j={0}, currentSweetness={1}", new Object[] { j, currentSweetnes }));

                if (currentSweetnes > S) {
                    System.out.println(j - 1);
                    break;
                }
            }
        }
        s.close();
    }

    @Test
    public void testSample() {
        final Integer a = new Integer(2);
        final long b = 2000300040005000L;
        System.out.println(a == b);

        final int c = (int) b;
        System.out.println(c);
    }

}
