package com.cp.controller;
import com.cp.pageBuilder;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/week3")
public class Week3ControllerPretty {
    static Week3Controller week3Core = new Week3Controller();

    @GetMapping("/")
    public String home(){
        return pageBuilder.buildPageWUnformattedBody(week3Core.home());
    }


    @GetMapping("/crewmember")
    public String crewmember(@RequestParam(required = false) boolean sort) {
        return pageBuilder.buildPageWUnformattedBody(week3Core.crewmember(sort));
    }


    @GetMapping("/crewmember/{id}")
    public String crewmembernumber(@PathVariable String id) {
        return pageBuilder.buildPageWUnformattedBody(week3Core.crewmembernumber(id));
    }


    @PostMapping("/crewmember")
    public String crewmemberadd(@RequestBody MultiValueMap<String,String> formBody) {
        return pageBuilder.buildPageWUnformattedBody(week3Core.crewmemberadd(formBody));
    }


    @GetMapping("/spaceship/current")
        public String spaceshipcurrent(@CookieValue(required = false, name = "current") Cookie myCookies) {
            return pageBuilder.buildPageWUnformattedBody(week3Core.spaceshipcurrent(myCookies));
    }

    @PostMapping("/spaceship/current")
    public String spaceshipsetcurrent(@RequestBody MultiValueMap<String, String> formBody, HttpServletResponse response) {
        return pageBuilder.buildPageWUnformattedBody(week3Core.spaceshipsetcurrent(formBody, response));
    }

}
