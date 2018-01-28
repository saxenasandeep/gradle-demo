/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Source SamplePractice.java created on Jan 22, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

class Node<T> {

    T type;

    Node<T> left;
    Node<T> right;

    Node(T type) {
        this.type = type;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeSample {

    private Logger log = LoggerFactory.getLogger(BinaryTreeSample.class);

    @Test
    public void testSample() {
        log.info("testSample");

    }

}
