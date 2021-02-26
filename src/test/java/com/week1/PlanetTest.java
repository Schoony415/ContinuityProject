package com.week1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.*;


public class PlanetTest {
    @Test
    public void createDefaultPlanet(){
        Planet tPlanet = new Planet();
        //assertEquals("Earth, distance 1",""+tPlanet);
        assertEquals(true, tPlanet.equals(new Planet()));
    }
    @Test
    public void createDefaultPlanet2(){
        Planet tPlanet = new Planet("Mars");
        assertEquals("Mars, distance 1",""+tPlanet);
    }
    @Test
    public void createPlanet(){
        Planet tPlanet = new Planet("Jupiter",10000);
        assertEquals("Jupiter, distance 10000",""+tPlanet);
    }
    @Test
    public void testGetName(){
        Planet tPlanet = new Planet();
        assertEquals("Earth",tPlanet.getName());
    }
    @Test
    public void testGetDistance(){
        Planet tPlanet = new Planet();
        assertEquals(1,tPlanet.getDistanceToNext());
    }
}
