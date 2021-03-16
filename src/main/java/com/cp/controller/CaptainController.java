package com.cp.controller;

import com.cp.dao.CrewMemberRepository;
import com.cp.model.Captain;
import com.cp.model.CrewMember;
import com.cp.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cap")
public class CaptainController {

    private final CrewMemberRepository repository;

    public CaptainController(CrewMemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(){
        return "Officer's Club";
    }

    @PostMapping("")
    @JsonView(Views.Compact.class)
    public Captain postcap(@RequestBody Captain input){
        return this.repository.save(input);
    }

    @GetMapping("")
    @JsonView(Views.Compact.class)
    public Iterable<Captain> getall(){
        Iterable<CrewMember> cmlist = new ArrayList<>();
        ArrayList<Captain> offlist = new ArrayList<>();
        cmlist = this.repository.findAll();
        for(CrewMember pawn:cmlist){
            if(pawn instanceof Captain){
                offlist.add((Captain) pawn);
            }
        }
        return offlist;
    }


}
