package com.cp.controller;

import com.cp.model.CrewMember;
import com.cp.dao.CrewMemberRepository;
import org.springframework.web.bind.annotation.*;

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
    public CrewMember savecm(@RequestBody CrewMember input){
        return this.repository.save(input);
    }
//Read	GET  	/employees/{id}	.findById   "show" route	Returns a single employee
    @GetMapping("/{id}")
    public Optional<CrewMember> getcm(@PathVariable long id){
        return this.repository.findById(id);
    }
//Update	PATCH	/employees/{id}	.save       "update" route	Updates attributes of the employee
    @PatchMapping("/{id}")
    public CrewMember updatecm(@PathVariable long id, @RequestBody CrewMember input){
        try{
        if(this.repository.existsById(id)){
            CrewMember temp = this.repository.findById(id).get();
            if(input.getMorale() != temp.getMorale()){
                temp.setMorale(input.getMorale());
            }
            if(input.getShirtColor() != temp.getShirtColor()){
                temp.setShirtColor(input.getShirtColor());
            }
            return this.repository.save(temp);
        }else{
            return savecm(input);
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
//Delete	DELETE	/employees/{id}	.deleteById "delete" route	Deletes the employee
    @DeleteMapping("/{id}")
    public String killcm(@PathVariable long id){
        CrewMember temp = this.repository.findById(id).get();
        this.repository.deleteById(id);
        return "("+id+") "+temp.getName()+" is gone";
    }
//List	GET  	/employees  	.findAll    "index" or "list" route	Returns a list of employees
    @GetMapping("")
    public Iterable<CrewMember> getall(){
        return this.repository.findAll();
    }

}//end of file
