package com.skxj.firstboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Snow on 7/10/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }*/
}

