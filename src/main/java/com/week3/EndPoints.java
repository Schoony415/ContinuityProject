package com.week3;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPoints {
    @GetMapping("/")
    public String home(){
        return "website worked!";
    }


}
