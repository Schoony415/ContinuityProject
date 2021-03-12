package com.cp.controller;

import com.cp.dao.SpaceShipRepository;
import com.cp.model.CrewMember;
import com.cp.model.SpaceShip;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/spaceship")
public class SpaceShipController {

    private final SpaceShipRepository repository;

    public SpaceShipController(SpaceShipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(){
        return "ss home()";
    }

//CRUD(L)	Verb	Path        	JPA         Name        	Purpose
//Create	POST	/employees  	.save       "create" route	Creates an employee

    @PostMapping("")
    public SpaceShip saveship(@RequestBody SpaceShip input){
        return this.repository.save(input);
    }
    //Read	GET  	/employees/{id}	.findById   "show" route	Returns a single employee
    @GetMapping("/{id}")
    public Optional<SpaceShip> getship(@PathVariable long id){
        return this.repository.findById(id);
    }
    //Update	PATCH	/employees/{id}	.save       "update" route	Updates attributes of the employee
    @PatchMapping("/{id}")
    public SpaceShip updateship(@PathVariable long id, @RequestBody SpaceShip input){
        try {
            if (this.repository.existsById(id)) {
                SpaceShip temp = this.repository.findById(id).get();
                if (input.getFuel() != temp.getFuel()) {
                    temp.setFuel(input.getFuel());
                }
                if (input.getCrewList() != temp.getCrewList()) {
                    temp.setCrewList((ArrayList) input.getCrewList());
                }
                return this.repository.save(temp);
            } else {
                return saveship(input);
            }
        }catch(IllegalArgumentException e){return null;}
    }

    public SpaceShip shipboardcm(long shipid){
        Optional<SpaceShip> temp = this.repository.findById(shipid);
        return temp.get();
    }
    //Delete	DELETE	/employees/{id}	.deleteById "delete" route	Deletes the employee
    @DeleteMapping("/{id}")
    public String killship(@PathVariable long id){
        SpaceShip temp = this.repository.findById(id).get();
        this.repository.deleteById(id);
        return "("+id+") "+temp.getName()+" is gone";
    }
    //List	GET  	/employees  	.findAll    "index" or "list" route	Returns a list of employees
    @GetMapping("")
    public Iterable<SpaceShip> getall(){
        return this.repository.findAll();
    }

    //direct copy from endpoints

    @GetMapping("/current")
    public String spaceshipcurrent(@CookieValue(required = false, name = "current") Cookie myCookies){
        //this will hopefully only grab the cookie that I want
        if(null != myCookies) {
            Optional<SpaceShip> temp = this.repository.findById(Long.parseLong(myCookies.getValue()));
            return "Your current spaceship has the id of " + myCookies.getValue() + " : \n" + temp.get().toString();
        }else
            return "You do not have a current spaceship";
        //return "";
    }

    //https://dzone.com/articles/how-to-use-cookies-in-spring-boot
    @PostMapping("/current")
    public String spaceshipsetcurrent(@RequestBody MultiValueMap<String, String> formBody, HttpServletResponse response){
        if(!formBody.get("spaceship").isEmpty()) {
            Optional<SpaceShip> temp = this.repository.findById(Long.parseLong(formBody.get("spaceship").get(0)));
            if(!temp.isEmpty()){
                Cookie shipcookie = new Cookie("current", formBody.get("spaceship").get(0));
                response.addCookie(shipcookie);
                return ("Spaceship set to "+formBody.get("spaceship").get(0)+" : \n"+temp.get().toString());
            }else{
                return "Please pick a valid ship";
            }
        }
        else{
            return "Please join a spaceship";
        }
        //return "";
    }

}//end of file
