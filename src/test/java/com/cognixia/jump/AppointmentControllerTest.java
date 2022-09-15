package com.cognixia.jump;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognixia.jump.controller.AppointmentController;
import com.cognixia.jump.model.Appointment;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(SpringExtension.class)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    void testGetAllAppointments() throws Exception {
        String uri = "/api/appointments";
        mvc.perform(get(uri))
        .andExpect(jsonPath("$[0].appointment_id", is("1")))
        .andExpect(jsonPath("$[0].appointment_date", is("2022-01-01")))
        .andExpect(jsonPath("$[0].appointment_time", is("12:00:00")))
        .andExpect(jsonPath("$[0].appointment_service", is("Routine Groom")))
        .andExpect(jsonPath("$[0].appointment_caretaker", is("Jane Doe")))
        .andExpect(jsonPath("$[0].appointment_price", is("100.99")));
    }

    @Test
    void testGetAppointmentById() throws Exception {
        String id = "1";
        String uri = "/api/appointments/" + id;
        mvc.perform(get(uri))
        .andExpect(jsonPath("$[0].appointment_date", is("2022-01-01")))
        .andExpect(jsonPath("$[0].appointment_time", is("12:00:00")))
        .andExpect(jsonPath("$[0].appointment_service", is("Routine Groom")))
        .andExpect(jsonPath("$[0].appointment_caretaker", is("Jane Doe")))
        .andExpect(jsonPath("$[0].appointment_price", is("100.99")));
    }

    @Test
    void testAddNewAppointment() throws Exception {
        String uri = "/api/appointments/new";
        Appointment apt = new Appointment();
        mvc.perform(post(uri).content(asJsonString(apt)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }  
}
