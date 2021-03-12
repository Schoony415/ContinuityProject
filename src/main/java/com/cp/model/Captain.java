package com.cp.model;

import com.cp.view.Views;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("*")
@JsonPropertyOrder({"id","name","shipid","morale","inspiration","shirtColor"})
@Entity
@Table(name="Officers")
public class Captain extends CrewMember {
    //private float morale=120.0f;
    //private String name="Leeroy J";
    @JsonView(Views.Detailed.class)
    private float inspiration;
    public Captain(){
        this.morale=120.0f;
        this.inspiration = 20.0f;
        this.name = "Kirk";
    }
    public Captain(String iname){
        this.inspiration = 20.0f;
        this.name = iname;
    }
    public float getInspiration(){return inspiration;}
    public void inspireTheTroops(List<CrewMember> house){
        for(CrewMember pawn : house)
            pawn.changeMorale(inspiration);
    }
    //Overwrites--------------------------
    public String toString(){return ("*"+this.name+" : "+this.morale+", i"+this.inspiration);}
    public boolean equals(Captain comp){
        if(this.morale==comp.morale)
            if(this.name.equals(comp.name))
                if(this.inspiration==comp.getInspiration())
                    return true;
        return false;
    }
    public CrewMember clone(){
        Captain nCpt = new Captain(name);
        return nCpt;
    }
}
