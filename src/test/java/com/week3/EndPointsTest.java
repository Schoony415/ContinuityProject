package com.week3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

//You must handle the following endpoints :
//- A GET request to the `/crewmember` endpoint with optional request parameters
    
//- A GET request to the `/crewmember/{crewmemberId}` endpoint

//- A POST request to the `/crewmember` endpoint which accepts form data in the request body

//- A GET request to the `/spaceship/current` which accesses the cookies to retrieve the current spaceship




}
