package com.week3;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EndPoints {
    @GetMapping("/")
    public String home(){
        return "website worked!";
    }

    @GetMapping("/crewmember")
    public String crewmember(@RequestParam(required = false) boolean sort){
        if (sort){
            return "This is a list of the crewmembers sorted alphabetically";
        }
        else{
            return "This is a list of the crewmembers unsorted";
        }

        //return "";
    }

    @GetMapping("/crewmember/{id}")
    public String crewmembernumber(@PathVariable String id){
        try{
            if (!(Integer.parseInt(id)==0)){
                return "This is the record for crewmember "+id;
            }
            else {
                return "Please access a valid crewmember's id";
            }
        }catch(Exception e){
            return "Please access a valid crewmember's id";
        }
        //return "";
    }

    @PostMapping("/crewmember")
    public String crewmemberadd(@RequestBody MultiValueMap<String,String> formBody){
        //see test example for how multivaluemap works
        return ""+formBody.get("name").get(0)+
                " has been added to the list of crewmembers with an id of "+
                formBody.get("crewmember_id").get(0)
        ;
        //return "";
    }

    @GetMapping("/spaceship/current")
    public String spaceshipcurrent(@CookieValue(required = false, name = "current") Cookie myCookies){
        //this will hopefully only grab the cookie that I want
        if(null != myCookies)
            return "Your current spaceship has the id of "+myCookies.getValue();
        else
            return "You do not have a current spaceship";
        //return "";
    }

    //https://dzone.com/articles/how-to-use-cookies-in-spring-boot
    @PostMapping("/spaceship/current")
    public String spaceshipsetcurrent(@RequestBody MultiValueMap<String, String> formBody, HttpServletResponse response){
        if(!formBody.get("spaceship").isEmpty()) {
            Cookie shipcookie = new Cookie("current", formBody.get("spaceship").get(0));
            response.addCookie(shipcookie);
            return "Spaceship set to "+formBody.get("spaceship").get(0);
        }
        else{
            return "Please join a spaceship";
        }
        //return "";
    }

}//end of file
