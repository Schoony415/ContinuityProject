package com.cp.controller;

import com.cp.model.*;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ss")
public class SolarSystemEndPoints {
    static Map<String, SolarSystem> mastersolarlist;

    @GetMapping("/")
    public String home(){
        return "going to display solar system here";
    }

    @PostMapping("/builder")
    public String buildss(@RequestBody(required = false) MultiValueMap<String,String> myBody){
        if(this.mastersolarlist==null){//first run master list will be null
            this.mastersolarlist = new HashMap<>();
        }
        try {
            if(myBody!=null) {
                //make it use a cookie for the solar system number
                if (myBody.containsKey("SystemName")) {
                    if (myBody.containsKey("spaceship")) {
                        //if(myBody.containsKey("system")){

                        //}else{//spaceship
                        mastersolarlist.put(myBody.get("SystemName").get(0),
                                new SolarSystem(myBody.get("SystemName").get(0),
                                new SpaceShip(myBody.get("spaceship").get(0))));
                        return mastersolarlist.get(myBody.get("SystemName").get(0)).toString();
                        //}
                    } else {//system name
                        mastersolarlist.put(myBody.get("SystemName").get(0),
                                new SolarSystem(myBody.get("SystemName").get(0)));
                        return mastersolarlist.get(myBody.get("SystemName").get(0)).toString();
                    }
                } else {//no name
                    mastersolarlist.put("Orion", new SolarSystem());
                    return mastersolarlist.get("Orion").toString();
                }
            }else{
                mastersolarlist.put("Orion", new SolarSystem());
                return mastersolarlist.get("Orion").toString();
                //return "aint got no body";
            }
        }catch (Exception e){
            return ""+e.toString();
        }
        //return "";
    }

    @GetMapping("/readout")
    public String displayall(@RequestParam(required = false) String systemname){
        if(systemname != null){
            if(mastersolarlist.containsKey(systemname)){
                return mastersolarlist.get(systemname).toString();
            }else{
                return "This system does not exist";
            }
        }else{
            return mastersolarlist.toString();
        }
    }



}
