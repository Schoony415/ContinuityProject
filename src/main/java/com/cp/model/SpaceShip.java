package com.cp.model;
import com.cp.view.Views;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//https://en.wikibooks.org/wiki/Java_Persistence/ManyToOne
//many to one implementation

@JsonPropertyOrder({"id","name","fuel","crewList"})
@Entity
@Table(name="SpaceShip")
public class SpaceShip {
    @JsonView(Views.Detailed.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @JsonView(Views.Detailed.class)
    //a fuel property as a float, defaulting to 100.0f
    private float fuel=100.0f;
    //a crewList property as an ArrayList containing CrewMember, defaulting to an empty list initialized as a new instance of a SpaceShip

    // The 'mappedBy = "owner"' attribute specifies that
    // the 'private Employee owner;' field in Phone owns the
    // relationship (i.e. contains the foreign key for the query to
    // find all phones for an employee.)
    @OneToMany(mappedBy = "shipid")
    @JsonView(Views.Detailed.class)
    private List<CrewMember> crewList;

    @JsonView(Views.justNames.class)
    private String name;

    public SpaceShip(){
        //this.fuel=100.0f;
        this.crewList = new ArrayList<>();
        this.name = "Rocket";
    }
    public SpaceShip(CrewMember newCrew){
        this();
        this.crewList.add(newCrew.clone());
    }
    public SpaceShip(List<CrewMember> newCrew){
        this();
        this.crewList = new ArrayList<>();
        for(CrewMember pawn : newCrew){
            this.crewList.add(pawn.clone());
        }
    }
    public SpaceShip(String iname){
        this();
        this.name = iname;
    }
    public SpaceShip(String iname, CrewMember newCrew){
        this(iname);
        this.crewList.add(newCrew.clone());
    }
    public SpaceShip(String iname, List<CrewMember> newCrew){
        this(iname);
        this.crewList = new ArrayList<>();
        for(CrewMember pawn : newCrew){
            this.crewList.add(pawn.clone());
        }
    }
    //a travelFast method, which reduces fuel by 20 and each crew members moral by 10
    public void travelFast(){
        fuel-=20.0f;
        //go through crewlist and reduece moral by 10
        for(CrewMember pawn: crewList)
            pawn.changeMorale(-10.0f);
    }
    //a refuel method, which increases fuel by 50 and reduces each crew members moral by 5
    public void refuel(){
        fuel+=50.0f;
        //go through crewlist and decrese moral by 5
        for(CrewMember pawn: crewList)
            pawn.changeMorale(-5.0f);
    }
    //a takeItEasy method, which reduces fuel by 5 and increases each crew members moral by 20
    public void takeItEasy(){
        fuel-=5.0f;
        //go through crewList and increase moral by 20
        for(CrewMember pawn: crewList)
            pawn.changeMorale(+20.0f);
    }
    //a fillCrew method, which adds a crewMember to the crewList
    public void fillCrew(CrewMember iCrew){
        crewList.add(iCrew.clone());
    }
    public void fillCrew(ArrayList<CrewMember> iCrew){
        for(CrewMember pawn : iCrew)
            fillCrew(pawn);
    }
    public float getFuel(){return fuel;}
    public List<CrewMember> getCrewList(){return crewList;}
    public CrewMember getMember(String iname){
        for(CrewMember check : crewList)
            if(check.getName().equals(iname)) return check;
        return null;
    }
    public boolean crewMemberExists(CrewMember comp){
        CrewMember pawn = this.getMember(comp.getName());
        if(pawn==null) return false;
        return pawn.equals(comp);
    }
    public String getName(){return name;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public void setCrewList(ArrayList<CrewMember> crewList) {
        this.crewList = crewList;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Overwrite-----------
    public String toString(){
        String tempStr = "";
        tempStr+="--Start of ship log\n";
        tempStr+="Ship: "+name+"\n";
        tempStr+="Fuel: "+fuel+"\n";
        tempStr+="Crew Members: \n";
        for(CrewMember check : crewList)
            tempStr+="-"+check+"\n";
        tempStr+="--end of ship log";
        return tempStr;
    }
    public boolean equals(SpaceShip comp){
        //boolean isequals = true;
        if(!this.name.equals(comp.name)) return false;
        //if(this.crewList.equals(comp.crewList)) return false;
        for(CrewMember pawn:crewList)
            if(!comp.crewMemberExists(pawn))
                return false;
        if(!(this.fuel==comp.fuel)) return false;

        return true;
    }
    public SpaceShip clone(){
        ArrayList<CrewMember> ncl = new ArrayList<>();
        for(CrewMember pawn : crewList)
            ncl.add(pawn.clone());
        SpaceShip nss = new SpaceShip(name, ncl);
        return nss;
    }


}