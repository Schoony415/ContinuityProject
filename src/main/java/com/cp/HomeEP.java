package com.cp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeEP {
    int viewcount = 0;
    @GetMapping("/")
    public String home(){
        viewcount++;
        System.out.println("Dear Diary: Look mom! Got a view!:"+viewcount);
        String mystring = "Default: Hello World!";
        //path to file on my computer without the file name
        //String path = "/Users/j2153034/Documents/GitHub/spring-playground/src/main/java/com/example/springpractice";
        String path = "src/main/resources/homepage.txt";
        String relpath = "../..";
        //just my file name with the leading slash
        String filename = "/TestText.txt";
        mystring = FileManager.readFileAsString(path);

        return mystring;
        //return "Hello Baby";
    }

    @GetMapping("/a")
    public String home2(){
        return "a";
    }

}
