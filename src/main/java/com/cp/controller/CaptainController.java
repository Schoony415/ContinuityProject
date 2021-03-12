package com.cp.controller;

import com.cp.dao.CrewMemberRepository;
import com.cp.model.Captain;
import com.cp.model.CrewMember;
import com.cp.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cap")
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
    public Captain postcap(@RequestBody Captain input){
        return this.repository.save(input);
    }
//    @GetMapping("")
//    public Iterable<Captain> getall(){
//        return this.repository.findAll();
//    }
}
