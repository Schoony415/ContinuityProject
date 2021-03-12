package com.cp.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.*;


public class CrewMemberTest {
    @Test
    public void createDefaultCrewMember(){
        CrewMember tPerson = new CrewMember();
        assertEquals("Leeroy J : 100.0",""+tPerson);
    }
    @Test
    public void createCrewMember(){
        CrewMember tPerson = new CrewMember("Timmy");
        assertEquals("Timmy : 100.0",""+tPerson);
    }
    @Test
    public void dropMoral(){
        CrewMember tPerson = new CrewMember();
        tPerson.changeMorale(-10.0f);
        assertEquals(90.0f,tPerson.getMorale());
    }
    @Test
    public void raiseMoral(){
        CrewMember tPerson = new CrewMember();
        tPerson.changeMorale(10.0f);
        assertEquals(110.0f,tPerson.getMorale());
    }
}
