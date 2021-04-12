package com.cp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Optional;

@RestController
public class HomeEP {
    int viewcount = 0;
    @GetMapping("/")
    public String home(){
        viewcount++;
        System.out.println("Dear Diary: Look mom! Got a view!:"+viewcount);
        /*
        String mystring = "Default: Hello World!";
        //path to file on my computer without the file name
        //String path = "/Users/j2153034/Documents/GitHub/spring-playground/src/main/java/com/example/springpractice";
        String path = "src/main/resources/homepage_old.html";
        String relpath = "../..";
        //just my file name with the leading slash
        String filename = "/TestText.txt";
        mystring = FileManager.readFileAsString(path);
        */
        String mystring = pageBuilder.homePage();
        return mystring;
        //return "Hello Baby";
    }

    @CrossOrigin(origins = "http://localhost:3000")//why does this have to be here?
    @GetMapping("/a")
    public testobj home2(){
        System.out.println("a");
        return new testobj("test a",1);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    class testobj{
        String name;
        int number;
    }
}
