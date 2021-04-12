package com.cp.controller;

import com.cp.dao.SolarSystemRepository;
import com.cp.model.*;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/ss")
public class SolarSystemEndPoints {
     Map<String, SolarSystem> mastersolarlist;

    private final SolarSystemRepository repository;

    //public SolarSystemEndPoints(){}

    public SolarSystemEndPoints(SolarSystemRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(){
        return "going to display solar system here";
    }

    @PostMapping("/old/builder")
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

    @PostMapping("/builder")
    public String buildssLight(@RequestBody(required = false) MultiValueMap<String,String> myBody){
        SolarSystemThin temp = new SolarSystemThin();
        try {
            System.out.printf("Making the Universe");
            //if(myBody!=null) {
                //todo add the freaking logic
            //}else{
                temp.setSolarName("Orion");
                ArrayList<Planet> tempsphere = new ArrayList<>();
                tempsphere.add(new Planet("OI", 500));
                tempsphere.add(new Planet("OII", 1000));
                tempsphere.add(new Planet("OIII", 1500));
                temp.setSphere( tempsphere );
                temp.setCurrentPlanet(temp.getPlanet(0).getName());//this is everchanging line
//            temp.setCurrentPlanet(temp.getPlanet(0));//this is everchanging line

            this.repository.save(temp);
                return ""+this.repository.findBySolarName("Orion").get().getId();
                //return "aint got no body";
            //}
        }catch (Exception e){
            return ""+e.toString();
        }
        //return "";
    }

    @GetMapping("/old/readout/s")
    public String displayallstring(@RequestParam(required = false) String systemname){
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

    @GetMapping("/old/readout")
    public SolarSystem displayall(@RequestParam(required = false) String systemname){
        if(systemname != null){
            if(mastersolarlist.containsKey(systemname)){
                return mastersolarlist.get(systemname);
            }else{
                return null;//"This system does not exist";
            }
        }else{
            return mastersolarlist.get(mastersolarlist.keySet().toArray()[0]);
        }
    }

    @GetMapping("/readout")
    public Optional<SolarSystemThin> displayallLight(@RequestParam(required = false) String systemname){
        if(systemname != null){
            return repository.findBySolarName(systemname);
        }else{
            return repository.findBySolarName("Orion");
        }
    }

}
