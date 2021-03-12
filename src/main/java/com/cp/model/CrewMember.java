package com.cp.model;

import com.cp.controller.SpaceShipController;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import com.cp.view.Views;

@JsonPropertyOrder({"id","name","shipid","morale","shirtColor"})
@Entity
@Table(name="CrewMember")
public class CrewMember {
    @JsonView(Views.Detailed.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @JsonView(Views.Compact.class)
    float morale = 100.0f;
    @JsonView(Views.Compact.class)
    String name = "Leeroy J";
    @JsonView(Views.Detailed.class)
    String shirtColor = "red";

    // Specifies the PHONE table does not contain an owner column, but
    // an OWNER_ID column with a foreign key. And creates a join to
    // lazily fetch the owner
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="crewList")
    @JsonView(Views.Detailed.class)
    SpaceShip shipid = null;

    public CrewMember(){
        //this.morale=100.0f;
        //this.name="Leeroy J";
    }
    public CrewMember(String iname){
        //this.morale=100.0f;
        this.name = iname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMorale(float morale) {
        this.morale = morale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShirtColor() {
        return shirtColor;
    }

    public void setShirtColor(String shirtColor) {
        this.shirtColor = shirtColor;
    }

    public SpaceShip getShipid() {
        return shipid;
    }

    public void setShipid(SpaceShip shipid) {
        this.shipid = shipid;
    }

    public String getName(){return name;}
    public float getMorale(){return morale;}
    //public void setMorale(float imorale){morale=imorale;}
    public void changeMorale(float imorale){morale+=imorale;}
    //Overwrite-----------
    public String toString(){return (""+name+" : "+morale);}
    public boolean equals( CrewMember comp){
        if(this.morale==comp.morale)
            if(this.name.equals(comp.name))
                return true;
        return false;
    }
    public  CrewMember clone(){
         CrewMember ncm = new  CrewMember(this.name);
         //ncm.setName(this.name);
        return ncm;
    }

}
/*
Create a CrewMember class with:

a morale property as a float, defaulting to 100.0f
a name property as a string that is set in its constructor
 */