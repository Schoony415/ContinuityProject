package com.cp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
@Table(name="Planet")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id = 0;
    //a name property as a string that is set in its constructor
    private String name;
    //a distanceToNext property as an int that is set in its constructor
    private int distanceToNext;
    @ManyToOne(fetch=FetchType.LAZY)//, cascade = CascadeType.ALL) //when you delete with cascade it also kills my spaceship
    @JoinColumn(name="sphere")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonBackReference
    SolarSystemThin ss = null;


    public Planet(){
        this.name = "Earth";
        this.distanceToNext=1;
    }
    public Planet(String iname){
        this.name = iname;
        this.distanceToNext=1;
    }
    public Planet(String iname, int distance){
        this.name = iname;
        this.distanceToNext=distance;
    }
    public String getName(){return name;}
    public int getDistanceToNext(){return distanceToNext;}
    //Overwrites---------------
    public String toString(){return (""+name+", distance "+distanceToNext);}
    public boolean equals(Planet comp){
        if(this.name.equals(comp.getName()))
            if(this.distanceToNext==comp.getDistanceToNext())
                return true;
        return false;
    }
    public Planet clone(){
        Planet npt = new Planet(name,distanceToNext);
        return npt;
    }
}
