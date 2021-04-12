package com.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cp"})
@EntityScan(basePackages="com.cp")
class springApplication {

    String ExpectedURL = "http://localhost:3000";

    public static void main(String[] args) {
        SpringApplication.run(springApplication.class, args);
    }

    //https://spring.io/guides/gs/rest-service-cors/#global-cors-configuration
    //required bit to make CORS work from js from other places on the network
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/a")
                        .allowedMethods("GET")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/test/fill")
                        .allowedMethods("GET")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/crewmember")
                        .allowedMethods("GET","POST")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/crewmember/d")
                        .allowedMethods("GET")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/spaceship")
                        .allowedMethods("GET","POST")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/spaceship/d")
                        .allowedMethods("GET")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/ss/builder")
                        .allowedMethods("POST")
                        .allowedOrigins(ExpectedURL)
                ;
                registry.addMapping("/ss/readout")
                        .allowedMethods("GET")
                        .allowedOrigins(ExpectedURL)
                ;

//                cm @PatchMapping("/board")
                registry.addMapping("/crewmember/board")
                        .allowedMethods("PATCH")
                        .allowedOrigins(ExpectedURL)
                ;
            }
        };
    }
}
