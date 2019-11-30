/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package sanrockzz.gradledemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main entry point
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @date : Aug 27, 2017
 *
 */

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "sanrockzz")
public class GradleDemoMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(GradleDemoMain.class);
        // app.setBanner(new ResourceBanner(new PathResource()));
        app.run(args);
    }

}