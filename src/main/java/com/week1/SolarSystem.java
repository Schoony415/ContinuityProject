package com.week1;
import java.util.ArrayList;

public class SolarSystem {
    //a name property as a string that is set in its constructor
    private String solarName;
    //a ship property as a SpaceShip, initialized as a new instance of a SpaceShip
    private SpaceShip myLittleShip;
    //a planetList property as an ArrayList, initialized with at least three new Planet instances.
    private ArrayList<Planet> sphere;
    //a currentPlanet property as a Planet, initialized as the first Planet in planetList
    //Pointer currentPlanet;
    private Planet currentPlanet;
    public SolarSystem(){
        this.solarName = "Orion";
        this.myLittleShip = new SpaceShip();
        this.sphere = new ArrayList<>();
        //Planet tempPlanet = new Planet("OI", 500);
        this.sphere.add(new Planet("OI", 500));
        this.sphere.add(new Planet("OII", 1000));
        this.sphere.add(new Planet("OIII", 1500));
        this.currentPlanet = this.sphere.get(0);
    }
    public SolarSystem(String iname){
        this();
        this.solarName = iname;/*
        this.myLittleShip = new SpaceShip();
        this.sphere = new ArrayList<>();
        //Planet tempPlanet = new Planet("OI", 500);
        this.sphere.add(new Planet(iname+"I", 500));
        this.sphere.add(new Planet(iname+"II", 1000));
        this.sphere.add(new Planet(iname+"III", 1500));
        this.currentPlanet = this.sphere.get(0);*/
    }
    public SolarSystem(String iname, SpaceShip ispaceShip){
        this(iname);
        //this.solarName = iname;
        this.myLittleShip = ispaceShip.clone();/*
        this.sphere = new ArrayList<>();
        //Planet tempPlanet = new Planet("OI", 500);
        this.sphere.add(new Planet(iname+"I", 500));
        this.sphere.add(new Planet(iname+"II", 1000));
        this.sphere.add(new Planet(iname+"III", 1500));
        this.currentPlanet = this.sphere.get(0);*/
    }
    public SolarSystem(String iname, SpaceShip ispaceShip, ArrayList<Planet> system){
        this(iname,ispaceShip);
        //this.solarName = iname;
        //this.myLittleShip = ispaceShip;
        //this.sphere = system;
        this.sphere = new ArrayList<>();
        for(Planet rock : system)
            this.sphere.add(rock.clone());
        this.currentPlanet = this.sphere.get(0);
    }
    public String getName(){return solarName;}
    public SpaceShip getSpaceShip(){return myLittleShip;}
    public ArrayList<Planet> getPlanets(){return sphere;}
    public Planet getPlanet(String pname){
        for(Planet rock : sphere)
            if(rock.getName().equals(pname))
                return rock;
        return null;
    }
    public Planet getCurrentPlanet(){return currentPlanet;}
    public SpaceShip getSpaceship(){return myLittleShip;}
    public boolean planetExists(Planet comp){
        Planet rock = this.getPlanet(comp.getName());
        if(rock == null) return false;
        return rock.equals(comp);
    }
    public void move(String pname){
        for(Planet check : sphere)
            if(check.getName().equals(pname))
                currentPlanet=check;
    }
    //Overwrites---------------
    public String toString(){
        String tempStr = "";
        tempStr+="--Start of SS log\n";
        tempStr+=solarName+"\n";
        tempStr+="Planets:\n";
        for(Planet check : sphere)
            tempStr+="-"+check+"\n";
        tempStr+="Ship: "+myLittleShip+"\n";
        tempStr+="Planet at: "+currentPlanet+"\n";
        tempStr+="--end of SS log";
        return tempStr;
    }
    public boolean equals(com.galvanize.SolarSystem comp){
        if(!this.getName().equals(comp.getName())) return false;
        //!need an elegant way to pass spaceship back and forth
        if(!this.myLittleShip.equals(comp.getSpaceShip())) return false;
        if(!this.currentPlanet.equals(comp.getCurrentPlanet())) return false;
        for(Planet rock : sphere){
            if(!(comp.planetExists(rock)))
                return false;
        }
        return true;
    }
    public com.galvanize.SolarSystem clone(){
        ArrayList<Planet> npl = new ArrayList<>();
        for(Planet rock : sphere)
            npl.add(rock.clone());
        com.galvanize.SolarSystem nss = new com.galvanize.SolarSystem(solarName, myLittleShip.clone(), npl);
        return nss;
    }


}
