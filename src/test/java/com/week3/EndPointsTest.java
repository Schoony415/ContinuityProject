package com.week3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.Cookie;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest(EndPoints.class)
public class EndPointsTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    MockMvc mvc;

    @Test
    public void testHomePageEndpoint() throws Exception{
        // localhost:8080/
        this.mvc.perform(get("/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string("website worked!")) // string that should appear in page
        ;
    }

    //example class with lots of stolen code
    //@Test
    public void testExample () throws Exception{
        String addressin =
                "/s";

        String addressvalues=
                "/little/lot";

        String querys =
                "?key=value&key2=value";

        //just a body text
        String bodytext =
                "this is my pretty body";
        //for building a map that imitates a form
        //multivalue class is a DataType mapped to a list of DataType, so you must treat values as list items
        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("type", Arrays.asList("rectangle"));
        bodymap.put("width",Arrays.asList("4"));
        bodymap.put("height",Arrays.asList("7"));

        Cookie myCooky =
                new Cookie("foo", "bar");

        String textout =
                "expected out";

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin+addressvalues+querys)
                .accept(MediaType.TEXT_PLAIN)
                //for adding string body
                .contentType(MediaType.TEXT_PLAIN)
                .content(bodytext)
                //for adding the form like body
                //.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                //.params(bodymap)
                .cookie(myCooky)
        ;
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                    .string(textout)) // string that should appear in page
        ;
    }//end test example

//You must handle the following endpoints :
//- A GET request to the `/crewmember` endpoint with optional request parameters
    @Test
    public void testCrewMember1() throws Exception{
        String addressin =
                "/crewmember";

        String querys =
                "?sort=true";

        String textout =
                "This is a list of the crewmembers sorted alphabetically";

        MockHttpServletRequestBuilder request1 =
            get(addressin+querys)
                .accept(MediaType.TEXT_PLAIN)
        ;
        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCrewMember2() throws Exception{
        String addressin =
                "/crewmember";

        String querys =
                "?sort=false";

        String textout =
                "This is a list of the crewmembers unsorted";

        MockHttpServletRequestBuilder request1 =
                get(addressin+querys)
                        .accept(MediaType.TEXT_PLAIN)
                ;
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCrewMember3() throws Exception{
        String addressin =
                "/crewmember";

        String querys =
                "";

        String textout =
                "This is a list of the crewmembers unsorted";

        MockHttpServletRequestBuilder request1 =
                get(addressin+querys)
                        .accept(MediaType.TEXT_PLAIN)
                ;
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

//- A GET request to the `/crewmember/{crewmemberId}` endpoint
    @Test
    public void testCrewMemberNumber1() throws Exception{
        String addressin =
                "/crewmember";

        String addressvalues=
                "/415";

        String textout =
                "This is the record for crewmember 415";

        MockHttpServletRequestBuilder request1 =
                get(addressin+addressvalues)
                    .accept(MediaType.TEXT_PLAIN)
        ;

        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCrewMemberNumber2() throws Exception{
        String addressin =
                "/crewmember";

        String addressvalues=
                "/thecurrentcrewmember";

        String textout =
                "Please access a valid crewmember's id";

        MockHttpServletRequestBuilder request1 =
                get(addressin+addressvalues)
                        .accept(MediaType.TEXT_PLAIN)
                ;

        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }


//- A POST request to the `/crewmember` endpoint which accepts form data in the request body
    @Test
    public void testCrewMemberAdd1() throws Exception{
        String addressin =
                "/crewmember";

        //for building a map that imitates a form
        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("name", Arrays.asList("Alice"));
        bodymap.put("crewmember_id",Arrays.asList("4"));

        String textout =
                "Alice has been added to the list of crewmembers with an id of 4";

        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                    .accept(MediaType.TEXT_PLAIN)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .params(bodymap)
                ;

        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCrewMemberAdd2() throws Exception{
        String addressin =
                "/crewmember";

        //for building a map that imitates a form
        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("name", Arrays.asList("Bob"));
        bodymap.put("crewmember_id",Arrays.asList("22"));

        String textout =
                "Bob has been added to the list of crewmembers with an id of 22";

        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.TEXT_PLAIN)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .params(bodymap)
                ;

        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

//- A GET request to the `/spaceship/current` which accesses the cookies to retrieve the current spaceship
    @Test
    public void testSpaceshipcookie1() throws Exception{
        String addressin =
                "/spaceship/current";

        Cookie myCooky =
                new Cookie("current", "12");

        String textout =
                "Your current spaceship has the id of 12";

        MockHttpServletRequestBuilder request1 =
            get(addressin)
                .accept(MediaType.TEXT_PLAIN)
                .cookie(myCooky)
        ;

        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testSpaceshipcookie2() throws Exception{
        String addressin =
                "/spaceship/current";

        //Cookie myCooky =
        //        new Cookie("","");
        //System.out.println(myCooky.toString());

        String textout =
                "You do not have a current spaceship";

        MockHttpServletRequestBuilder request1 =
            get(addressin)
                .accept(MediaType.TEXT_PLAIN)
                //.cookie(myCooky)//removing it trying to have cookie be empty
        ;

        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testSpaceshipcookie3() throws Exception{
        String addressin =
                "/spaceship/current";

        Cookie myCooky1 =
                new Cookie("current", "12");
        Cookie myCooky2 = //testing with multiple cookies
                new Cookie("captain", "15");

        String textout =
                "Your current spaceship has the id of 12";

        MockHttpServletRequestBuilder request1 =
            get(addressin)
                .accept(MediaType.TEXT_PLAIN)
                .cookie(myCooky1)
                .cookie(myCooky2)
        ;

        this.mvc.perform(request1)//.param("key","value")))
            .andExpect(status().isOk()) // 200 class, things be good
            .andExpect(content()
                .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testSpaceshipcookie4() throws Exception{
        String addressin =
                "/spaceship/current";

        Cookie myCooky = //testing with a wrong cookie
                new Cookie("captain", "15");

        String textout =
                "You do not have a current spaceship";

        MockHttpServletRequestBuilder request1 =
                get(addressin)
                        .accept(MediaType.TEXT_PLAIN)
                        .cookie(myCooky)
                ;

        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

//Take it to the next level. Your journey into outerspace is just beginning!
//
//You could create additional endpoints to handle new functionality.
//Add a POST request to /spaceship/current which sets your current spaceship using cookies
//Add additional functionality, behavior, or methods to existing endpoints

//post to spaceship to give a cookie
    @Test
    public void testSpaceshipGiveCookie1() throws Exception{
        String addressin =
                "/spaceship/current";

        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("spaceship", Arrays.asList("5"));

        Cookie myCooky =
                new Cookie("captian", "15");

        String textout =
                "Spaceship set to 5";

        MockHttpServletRequestBuilder request1 =
            post(addressin)
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(bodymap)
                .cookie(myCooky)
        ;
    
        this.mvc.perform(request1)
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

}//end of file
