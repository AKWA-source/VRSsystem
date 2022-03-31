package com.example.vrsystem.Controller;


import com.example.VRSystem.Model.Vaccine_registration;
import com.example.vrsystem.VRSystemApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

public class VacRegControllerTest extends VRSystemApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    public void addBooking() throws Exception {
//        String uri = "/Project/REST-API/addbooking/2/13";
//        Vaccine_registration vacreg = new Vaccine_registration();
//        vacreg.setRegistration_date(Date.valueOf("2022-08-30"));
//        vacreg.setRegistration_time(Time.valueOf("04:50:00"));
//        vacreg.setClinic_address("157157");
//        vacreg.setDose_number((long) 2);
//        vacreg.setVc_center((long)12);
//       
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJson = objectMapper.writeValueAsString(vacreg);
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Booked Successful";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected, result);
//    }


    
    
    
    
    
    
    
    
    
    
    
//    @Test
//    public void deleteUserBooking() throws Exception {
//        String uri = "/Project/REST-API/user/2/deletebooking/10";
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Booking Cancelled Successfully";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected, result);
//    }
    
    
    
    
    
    
    
    
    
    
}