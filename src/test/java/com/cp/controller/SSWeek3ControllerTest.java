package com.cp.controller;

import com.cp.model.SolarSystem;
import com.cp.model.SpaceShip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SolarSystemEndPoints.class)
public class SSWeek3ControllerTest {

    @Autowired
    MockMvc mvc;

    Map<String, SolarSystem> testsystemmap = new HashMap<>();

    @Test
    public void testHomePageEndpoint() throws Exception{
        // localhost:8080/
        this.mvc.perform(get("/ss/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string("going to display solar system here")) // string that should appear in page
        ;
    }

    @Test
    public void testBuildSSEndPoint1() throws Exception{
        SolarSystem basesolarsystem = new SolarSystem();
        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put("Orion",basesolarsystem);

        String addressin =
                "/ss/builder";

        String textout =
                basesolarsystem.toString();

        MockHttpServletRequestBuilder request1 =
                post(addressin)
                        .accept(MediaType.TEXT_PLAIN)
                ;

        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testBuildSSEndPoint2() throws Exception{
        String systemname = "BigBlue";
        SolarSystem basesolarsystem = new SolarSystem(systemname);
        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put(systemname,basesolarsystem);

        String addressin =
                "/ss/builder";

        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("SystemName", Arrays.asList(systemname));

        String textout =
                basesolarsystem.toString();

        MockHttpServletRequestBuilder request1 =
            post(addressin)
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(bodymap)
        ;

        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testBuildSSEndPoint3() throws Exception{
        String systemname = "Alpha Centi";
        String shipname = "YoMamma's ship";
        SolarSystem basesolarsystem = new SolarSystem(systemname,new SpaceShip(shipname));
        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put(systemname,basesolarsystem);

        String addressin =
                "/ss/builder";

        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("SystemName", Arrays.asList(systemname));
        bodymap.put("spaceship", Arrays.asList(shipname));

        String textout =
                basesolarsystem.toString();

        MockHttpServletRequestBuilder request1 =
                post(addressin)
                        .accept(MediaType.TEXT_PLAIN)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .params(bodymap)
                ;

        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testReadOutEndPoint1() throws Exception{
        //this fails because the class holds data from the tests but the tests don't hold data between each other
        SolarSystem basesolarsystem = new SolarSystem();

        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put("Orion",basesolarsystem);

        String addressin =
                "/ss/readout";

        String textout =
                testsystemmap.toString();

        MockHttpServletRequestBuilder request1 =
                get(addressin)
                        .accept(MediaType.TEXT_PLAIN)
                ;
        //have to build one system to get one back
        this.mvc.perform(post("/ss/builder").accept(MediaType.TEXT_PLAIN));
        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testReadOutEndPoint2() throws Exception{
        SolarSystem basesolarsystem = new SolarSystem();
        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put("Orion",basesolarsystem);

        String addressin =
                "/ss/readout";
        String querys =
                "?systemname=AlphaC";

        String textout =
                "This system does not exist";

        MockHttpServletRequestBuilder request1 =
                get(addressin+querys)
                        .accept(MediaType.TEXT_PLAIN)
                ;
        //have to build one system to get one back
        this.mvc.perform(post("/ss/builder").accept(MediaType.TEXT_PLAIN));
        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testReadOutEndPoint4() throws Exception{
        SolarSystem basesolarsystem = new SolarSystem();
        if(testsystemmap==null) testsystemmap=new HashMap<>();
        testsystemmap.put("Orion",basesolarsystem);

        String addressin =
                "/ss/readout";
        String querys =
                "?systemname=Orion";

        String textout =
                basesolarsystem.toString();

        MockHttpServletRequestBuilder request1 =
                get(addressin+querys)
                        .accept(MediaType.TEXT_PLAIN)
                ;
        //have to build one system to get one back
        this.mvc.perform(post("/ss/builder").accept(MediaType.TEXT_PLAIN));
        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }




}//end of file
