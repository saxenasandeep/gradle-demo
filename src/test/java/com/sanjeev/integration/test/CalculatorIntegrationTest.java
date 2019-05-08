/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.integration.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms.nao.csid.model.ICalculator;
import com.sanjeev.gradledemo.config.ClientConfig;

/**
 * Source CalculatorTest.java created on Sep 9, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Ignore
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientConfig.class)
public class CalculatorIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICalculator calc;

    @Test
    public void test() {
        log.info("Result test {}", calc.add(2, 1));
    }

}
