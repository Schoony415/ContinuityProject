package com.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com"})
//@EntityScan(basePackages="com")
public class springApplication {

    public static void main(String[] args) {
        SpringApplication.run(springApplication.class, args);
    }

}
