package com.example.vrsystem.Controller;


import com.example.vrsystem.VRSystemApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class LoginLogoutControllerTest extends VRSystemApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    public void login() throws Exception {
//        String uri = "/Project/REST-API/login?username=user1&password=2e3hr45i";
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Incorrect username or password";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected,result);
//    }
//
//
//    @Test
//    public void logout() throws Exception {
//        String uri = "/Project/REST-API/logout/user/1";
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Logout Successful";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected, result);
//    }

}