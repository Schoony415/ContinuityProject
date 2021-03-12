package com.cp.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.*;
import java.util.ArrayList;

public class SpaceShipTest {
    @Test
    public void createOneCrewShip(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        assertEquals(true,tShip.getMember("Luki").equals(tCrew));
    }
    @Test
    public void createCrewShip(){        ArrayList<CrewMember> tCrew = new ArrayList<>();
        tCrew.add(new CrewMember("Alex"));
        tCrew.add(new CrewMember("Bobby"));
        tCrew.add(new CrewMember("Chance"));
        SpaceShip tShip = new SpaceShip(tCrew);
        for(CrewMember pawn:tCrew)
            assertEquals(true, tShip.crewMemberExists(pawn));
    }
    @Test
    public void addCrewTest(){
        ArrayList<CrewMember> tCrew = new ArrayList<>();
        tCrew.add(new CrewMember("Alex"));
        tCrew.add(new CrewMember("Bobby"));
        tCrew.add(new CrewMember("Chance"));
        SpaceShip tShip = new SpaceShip(tCrew);
        CrewMember tNoob = new CrewMember("Zanny");
        tShip.fillCrew(tNoob);
        tCrew.add(tNoob);
        for(CrewMember pawn:tCrew)
            assertEquals(true, tShip.crewMemberExists(pawn));//tCrew,tShip.getCrewList());
    }
    @Test
    public void FlyFastTest(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        assertEquals(100.0f,tShip.getFuel());
        tShip.travelFast();
        assertEquals(80.0f,tShip.getFuel());
        assertEquals(90.0f,tShip.getMember("Luki").getMorale());
    }
    @Test
    public void FlyEasyTest(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        assertEquals(100.0f,tShip.getFuel());
        tShip.takeItEasy();
        assertEquals(95.0f,tShip.getFuel());
        assertEquals(120.0f,tShip.getMember("Luki").getMorale());
    }
    @Test
    public void RefuelTest(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        assertEquals(100.0f,tShip.getFuel());
        tShip.refuel();
        assertEquals(150.0f,tShip.getFuel());
        assertEquals(95.0f,tShip.getMember("Luki").getMorale());
    }
}
