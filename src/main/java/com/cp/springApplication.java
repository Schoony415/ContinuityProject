package com.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cp"})
@EntityScan(basePackages="com.cp")
class springApplication {

    public static void main(String[] args) {
        SpringApplication.run(springApplication.class, args);
    }

}
