/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */
package com.sanjeev.demo;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello Gradle main entry class
 * 
 * @author : Sanjeev Saxena
 * email : sanrocks123@gmail.com
 * date : Oct 28, 2017
 * 
 */

public class HelloGradle {

	private final Logger log = LoggerFactory.getLogger(HelloGradle.class);

	public static void main(String... args) {
		new HelloGradle().run();

	}

	private void run() {
		log.info("Hello Gradle!");

		log.info("Sample JSON Objects: {}", new JSONObject().toString());
	}

}
