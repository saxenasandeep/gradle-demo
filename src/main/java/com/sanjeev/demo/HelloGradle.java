/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */
package com.sanjeev.demo;

import java.util.logging.Logger;

/**
 * 
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @date : Oct 28, 2017
 * 
 */

public class HelloGradle {

	private final Logger log = Logger.getLogger(HelloGradle.class.getName());

	public static void main(String... args) {
		new HelloGradle().run();

	}

	/**
	 * 
	 */
	private void run() {
		log.info("Hello Gradle!");
	}

}
