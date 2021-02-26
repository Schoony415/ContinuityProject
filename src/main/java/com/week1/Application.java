package com.week1;

import java.util.ArrayList;

public class Application {

    public static void main(String... args) {
        ///*
        Captain myCaptain = new Captain("Kirk");
        //System.out.println(myCaptain);
        CrewMember commo = new CrewMember("Spock");
        //System.out.println(commo);
        ArrayList<CrewMember> manifest = new ArrayList<>();
        manifest.add(myCaptain);
        manifest.add(commo);
        //!look into deep copy for crewmember and also using that in spaceship
        //and also planets and solorsystem
        SpaceShip Enti = new SpaceShip("Enterprise", manifest);
        Enti.travelFast();
        System.out.println(Enti);
        commo.morale-=50f;
        System.out.println("--50test--\nbase variable: "+commo+" || ship variable: "+Enti.getMember("Spock"));
        //commo.morale-=50f;
        //System.out.println(commo.morale);
        SpaceShip comp1 = new SpaceShip();
        SpaceShip comp2 = new SpaceShip();
        System.out.println("equals: "+comp1.equals(comp2));
        //*//*
        ArrayList<CrewMember> tCrew = new ArrayList<>();
        tCrew.add(new CrewMember("Alex"));
        tCrew.add(new CrewMember("Bobby"));
        tCrew.add(new CrewMember("Chance"));
        SpaceShip tShip = new SpaceShip(tCrew);
        for(CrewMember pawn:tCrew)
            System.out.println(""+tShip.crewMemberExists(pawn));
        //*/

        System.out.println("---testing the ref pass through to inspire troops a lazy way---");
        System.out.println("---creating my solar system---");
        SolarSystem mylittlesystem = new SolarSystem("RAWR",Enti);
        mylittlesystem.getSpaceShip().travelFast();
        mylittlesystem.getSpaceShip().fillCrew(tCrew);
        System.out.println(mylittlesystem.getSpaceship().getCrewList());
        System.out.println("---insiring troops---");
        //get member returns crewmember, but because I know it's a captain I have to cast it's type
        // to make it work. I'm not sure if it's just a compiler thing or an always thing
        //then I'm passing the crew manifest reference to my captain to inspire
        ((Captain)mylittlesystem.getSpaceship().getMember("Kirk")).inspireTheTroops(mylittlesystem.getSpaceship().getCrewList());
        System.out.println(mylittlesystem.getSpaceship().getCrewList());



    }//end main
}//end file
/*
The classes you must create are:

A CrewMember class
A Spaceship class to hold your crew and fuel
A Planet class
A SolarSystem class which holds our planets and serves as our game board

----------------

Write tests to verify that your Classes behave as you expect

Take it to the next level. Your journey into outerspace is just beginning!

You could create additional subclasses for your SpaceShip and crew, with unique behavior
Experiment with game logic and moving your ship across the different planets
Add additional functionality, behavior, or methods, to existing classes
 */