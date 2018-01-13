/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.spring.boot.main;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * Main entry point
 * 
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @date : Aug 27, 2017
 * 
 */

@ComponentScan(basePackages = "com.sanjeev.spring.boot")
@SpringBootApplication
public class SpringBootMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootMain.class);

        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment env, Class<?> classz, PrintStream ps) {
                ps.println("*******************************************************************************");
                ps.println(
                        "                                Welcome to SpringBoot Application                              ");
                ps.println("*******************************************************************************");
            }
        });
        app.run(args);
    }

}