package com.cp.controller;

import com.cp.model.CrewMember;
import com.cp.dao.CrewMemberRepository;
import com.cp.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/crewmember")
public class CrewMemberController {

    private final CrewMemberRepository repository;

    public CrewMemberController(CrewMemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(){
        return "cm home()";
    }

//CRUD(L)	Verb	Path        	JPA         Name        	Purpose
//Create	POST	/employees  	.save       "create" route	Creates an employee
    @PostMapping("")
    @JsonView(Views.Compact.class)
    public CrewMember savecm(@RequestBody CrewMember input){
        return this.repository.save(input);
    }
//Read	GET  	/employees/{id}	.findById   "show" route	Returns a single employee
    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public Optional<CrewMember> getcm(@PathVariable long id){
        return this.repository.findById(id);
    }
//Update	PATCH	/employees/{id}	.save       "update" route	Updates attributes of the employee
    @PatchMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public CrewMember updatecm(@PathVariable long id, @RequestBody HashMap<String,String> input){// @RequestBody CrewMember input){
        try{
        if(this.repository.existsById(id)){
            CrewMember temp = this.repository.findById(id).get();
            //old based on crewmember body
//            if(input.getMorale() != temp.getMorale()){
//                temp.setMorale(input.getMorale());
//            }
//            if(input.getShirtColor() != temp.getShirtColor()){
//                temp.setShirtColor(input.getShirtColor());
//            }
            //new based on hash body
            for(String key: input.keySet()){
                switch (key.toLowerCase()){
                    case "name": temp.setName(input.get(key)); break;
                    case "morale": temp.setMorale(Float.parseFloat(input.get(key))); break;
                    case "shirtcolor":
                    case "shirt": temp.setShirtColor(input.get(key)); break;
//                    case "ship":
//                    case "shipid": temp.setShipid((com.cp.model.SpaceShip)input.get(key)); break;
                }
            }
            return this.repository.save(temp);
        }else{
            return null;//savecm(input);
        }
        }catch(IllegalArgumentException e){return null;}
    }
//    @PatchMapping("/board")
//    public String cmboardship(@RequestBody long shipid, @RequestBody long crewid){
//        Optional<CrewMember> temp = this.repository.findById(crewid);
//        if(temp.isEmpty()){return "This crew member doesn't exist";}
//        this.repository.deleteById(crewid);
//        //com.cp.model.SpaceShip ss = com.cp.controller.SpaceShipController.shipboardcm(shipid);
//
//
//        return "";
//    }

//put mapping?!? just an overwrite
    @PutMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public CrewMember updatecm(@PathVariable long id, @RequestBody CrewMember input){
        try {
            input.setId(id);
            return this.repository.save(input);
        }catch(IllegalArgumentException e){
            return null;
        }
    }

//Delete	DELETE	/employees/{id}	.deleteById "delete" route	Deletes the employee
    @DeleteMapping("/{id}")
    public String killcm(@PathVariable long id){
        try {
            CrewMember temp = this.repository.findById(id).get();
            this.repository.deleteById(id);
            return "(" + id + ") " + temp.getName() + " is gone";
        }catch (IllegalArgumentException e){
            return "could not delete";
        }
    }
//List	GET  	/employees  	.findAll    "index" or "list" route	Returns a list of employees
    @GetMapping("")
    @JsonView(Views.Compact.class)
    public Iterable<CrewMember> getall(){
        return this.repository.findAll();
    }
    @GetMapping("/d")
    @JsonView(Views.Detailed.class)
    public Iterable<CrewMember> getalld(){
        return this.repository.findAll();
    }
    @GetMapping("/n")
    @JsonView(Views.justNames.class)
    public Iterable<CrewMember> getalln(){
        return this.repository.findAll();
    }

    //ROCKS FALL EVERYONE DIES! -mad DM
    @DeleteMapping("/purge")
    public String drop(){
        this.repository.deleteAll();
        return "Rocks fall! Everyone dies.. Bye.";
    }

}//end of file
