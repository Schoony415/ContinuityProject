package com.week1;
import java.util.ArrayList;

public class SpaceShip {
    //a fuel property as a float, defaulting to 100.0f
    private float fuel=100.0f;
    //a crewList property as an ArrayList containing CrewMember, defaulting to an empty list initialized as a new instance of a SpaceShip
    private ArrayList<CrewMember> crewList;
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
    public SpaceShip(ArrayList<CrewMember> newCrew){
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
    public SpaceShip(String iname, ArrayList<CrewMember> newCrew){
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
    public ArrayList<CrewMember> getCrewList(){return crewList;}
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