/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point
 * 
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @date : Aug 27, 2017
 * 
 */

@SpringBootApplication
public class GradleDemoMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GradleDemoMain.class);
        app.run(args);
    }

}