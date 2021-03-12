package com.cp.model;

import java.util.ArrayList;
import java.util.List;

public class Captain extends CrewMember {
    //private float morale=120.0f;
    //private String name="Leeroy J";
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
