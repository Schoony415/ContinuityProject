package com.week1;

public class Planet {
    //a name property as a string that is set in its constructor
    private String name;
    //a distanceToNext property as an int that is set in its constructor
    private int distanceToNext;
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
