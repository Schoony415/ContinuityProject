package com.cp.controller;

import com.cp.model.CrewMember;
import com.cp.dao.CrewMemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class CMCTest {

        @Autowired
        MockMvc mvc;
        @Autowired
        CrewMemberRepository repository;

        ObjectMapper objectMapper = new ObjectMapper();

        String requestmap = "/crewmember";

        @Test
        //@Transactional //for database
        //@Rollback //for database
        public void testhome() throws Exception{

            String addressin =
                    "/";

            String textout = "cm home()";

            //building my packet
            MockHttpServletRequestBuilder request1 =
                    //post test
                    get(requestmap+addressin)
                            .accept(MediaType.TEXT_PLAIN)
                    ;
            //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;

        }


        @Test
        @Transactional //for database
        @Rollback //for database
        public void testpush() throws Exception{
                String cm1name = "gary";
                CrewMember cm1 = new CrewMember(cm1name);

                String addressin =
                        "";

                String textout = "week4 home()";

                String jsontext = objectMapper.writeValueAsString(cm1);

                //building my packet
                MockHttpServletRequestBuilder request1 =
                        //post test
                        post(requestmap+addressin)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsontext)
                        ;
                //shooting the request to see what happens
                this.mvc.perform(request1)//.param("key","value")))
                        .andExpect(status().isOk()) // 200 class, things be good
//                        .andExpect(content()
//                                .string(jsontext)) // string that should appear in page
                        .andExpect(jsonPath("$.name",is(cm1name)))
                ;

        }

}//end of file
