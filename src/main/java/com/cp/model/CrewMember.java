package com.cp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import com.cp.view.Views;

@JsonPropertyOrder({"id","name","shipname","morale","shirtColor"})
@Entity
@Table(name="CrewMember")
public class CrewMember {
    @JsonView(Views.Detailed.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @JsonView(Views.Compact.class)
    float morale = 100.0f;
    @JsonView(Views.justNames.class)
    String name = "Leeroy J";
    @JsonView(Views.Detailed.class)
    String shirtColor = "red";


    @JsonView(Views.Detailed.class)
    // Specifies the PHONE table does not contain an owner column, but
    // an OWNER_ID column with a foreign key. And creates a join to
    // lazily fetch the owner
    @ManyToOne(fetch=FetchType.LAZY)//, cascade = CascadeType.ALL) //when you delete with cascade it also kills my spaceship
    @JoinColumn(name="ship_id")
    @JsonBackReference
    SpaceShip shipname = null;

    //long shipnumber = shipname.id;

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

    public SpaceShip getShipname() {
        return shipname;
    }

    public void setShipname(SpaceShip shipname) {
        this.shipname = shipname;
    }

    public String getName(){return name;}
    public float getMorale(){return morale;}
    //public void setMorale(float imorale){morale=imorale;}
    public void changeMorale(float imorale){morale+=imorale;}

//    public long getShipnumber() {
//        return shipnumber;
//    }
//
//    public void setShipnumber(long shipnumber) {
//        this.shipnumber = shipnumber;
//    }

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