package com.example.vrsystem.Controller;


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

public class ScheduleControllerTest extends VRSystemApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    public void addSchedule() throws Exception {
//        String uri = "/Project/REST-API/doctor/1/addschedule";
//        Schedule schedule = new Schedule();
//        schedule.setFrom_time(Time.valueOf("08:00:00"));
//        schedule.setTo_time(Time.valueOf("12:00:00"));
//        schedule.setDate(Date.valueOf("2020-08-29"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJson = objectMapper.writeValueAsString(schedule);
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Schedule Added Successful";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected, result);
//    }

//    @Test
//    public void deleteSchedule() throws Exception {
//        String uri = "/Project/REST-API/doctors/1/deleteschedules/28";
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String result = mvcResult.getResponse().getContentAsString();
//        String expected = "Schedule Deleted Successfully";
//        System.out.println("\nActual: " + result);
//        System.out.println("Expected: " + expected + "\n");
//        assertEquals(expected, result);
//    }
}