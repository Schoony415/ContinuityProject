package com.cp.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.*;
import java.util.ArrayList;

public class SolarSystemTest {
    @Test
    public void createDefaultSystem(){
        /*
        SolarSystem tSystem = new SolarSystem();
        String DStr = "";
        DStr="--Start of log\nOrion\nPlanets:\n-OI, distance 500\n-OII, distance 1000\n-OIII, distance 1500\n";
        DStr+="Ship: --Start of log\nShip: Rocket\nFuel: 100.0\nCrew Members: \n--end of log\n";
        DStr+="Planet at: OI, distance 500\n--end of log";
        assertEquals(DStr,""+tSystem);*/
        SpaceShip comp1 = new SpaceShip();
        SpaceShip comp2 = new SpaceShip();
        assertEquals(true, comp1.equals(comp2));
    }
    @Test
    public void createNameSystem(){
        SolarSystem tSystem = new SolarSystem("Alpha Centi");/*
        String DStr = "";
        DStr="--Start of log\nAlpha Centi\nPlanets:\n-Alpha CentiI, distance 500\n-Alpha CentiII, distance 1000\n-Alpha CentiIII, distance 1500\n";
        DStr+="Ship: --Start of log\nShip: Rocket\nFuel: 100.0\nCrew Members: \n--end of log\n";
        DStr+="Planet at: Alpha CentiI, distance 500\n--end of log";
        assertEquals(DStr,""+tSystem);*/
        assertEquals(true, tSystem.equals(new SolarSystem("Alpha Centi")));
    }
    @Test
    public void createNameShipSystem(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        SolarSystem tSystem = new SolarSystem("Alpha Centi",tShip);
        /*
        String DStr = "";
        DStr="--Start of log\nAlpha Centi\nPlanets:\n-Alpha CentiI, distance 500\n-Alpha CentiII, distance 1000\n-Alpha CentiIII, distance 1500\n";
        DStr+="Ship: --Start of log\nShipNameHere\nFuel: 100.0\nCrew Members: \n-Luki : 100\n--end of log\n";
        DStr+="Planet at: Alpha CentiI, distance 500\n--end of log";
        */
        assertEquals(true,tSystem.getSpaceship().getMember("Luki").equals(tCrew));
    }
    public void createNameShipPlanetsSystem(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        ArrayList<Planet> tPlanets = new ArrayList<>();
        tPlanets.add(new Planet("OI", 500));
        tPlanets.add(new Planet("OII", 1000));
        tPlanets.add(new Planet("OIII", 1500));
        SolarSystem tSystem = new SolarSystem("Alpha Centi",tShip,tPlanets);
        /*
        String DStr = "";
        DStr="--Start of log\nAlpha Centi\nPlanets:\n-Alpha CentiI, distance 500\n-Alpha CentiII, distance 1000\n-Alpha CentiIII, distance 1500\n";
        DStr+="Ship: --Start of log\nShipNameHere\nFuel: 100.0\nCrew Members: \n-Luki : 100\n--end of log\n";
        DStr+="Planet at: Alpha CentiI, distance 500\n--end of log";
        */
        assertEquals(true,tSystem.getPlanets().equals(tPlanets));
    }
    @Test
    public void getPlanetTest(){
        SolarSystem tSystem = new SolarSystem();
        String DStr = "OI, distance 500";
        assertEquals(DStr,""+tSystem.getCurrentPlanet());
    }
    @Test
    public void getSpaceShipTest(){
        CrewMember tCrew = new CrewMember("Luki");
        SpaceShip tShip = new SpaceShip(tCrew);
        SolarSystem tSystem = new SolarSystem("Alpha Centi",tShip);
        assertEquals(true,tSystem.getSpaceship().equals(tShip));
    }

}
