package com.week1;

public class CrewMember {
    float morale=100.0f;
    String name="Leeroy J";
    public CrewMember(){
        //this.morale=100.0f;
        //this.name="Leeroy J";
    }
    public CrewMember(String iname){
        //this.morale=100.0f;
        this.name=iname;
    }
    public String getName(){return name;}
    public float getMorale(){return morale;}
    //public void setMorale(float imorale){morale=imorale;}
    public void changeMorale(float imorale){morale+=imorale;}
    //Overwrite-----------
    public String toString(){return (""+name+" : "+morale);}
    public boolean equals(com.galvanize.CrewMember comp){
        if(this.morale==comp.morale)
            if(this.name.equals(comp.name))
                return true;
        return false;
    }
    public com.galvanize.CrewMember clone(){
        com.galvanize.CrewMember ncm = new com.galvanize.CrewMember(name);
        return ncm;
    }
}
/*
Create a CrewMember class with:

a morale property as a float, defaulting to 100.0f
a name property as a string that is set in its constructor
 */