/*

package com.cognixia.jump;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognixia.jump.controller.AppointmentController;
import com.cognixia.jump.model.Appointment;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.PetInfo;
import com.cognixia.jump.repository.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(SpringExtension.class)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {
    
    private static String uri = "";

    @Autowired
    private MockMvc mvc;

    @Test
    void testGetAllAppointments() throws Exception {
        uri = "/api/appointments";
        List<Appointment> appointments = new ArrayList<>();
        PetInfo pet1 = new PetInfo(1L, "Test Pet", 12, "Dog", "Poodle", false, new Customer());
        PetInfo pet2 = new PetInfo(2L, "Pet Test", 4, "Dog", "Lab", true, new Customer());
        appointments.add(new Appointment(1L, LocalDate.now(), LocalTime.now(), "Routine Groom", "Jane Doe", 100.99));
        appointments.add(new Appointment(2L, LocalDate.now(), LocalTime.now(), "Premium Groom", "Jane Doe", 199.99));
    }

    @Test
    void testGetAppointmentById() throws Exception {
        String id = "1";
        uri = "/api/appointments/" + id;
        mvc.perform(get(uri))
        .andExpect(jsonPath("$[0].appointment_date", is("2022-01-01")))
        .andExpect(jsonPath("$[0].appointment_time", is("12:00:00")))
        .andExpect(jsonPath("$[0].appointment_service", is("Routine Groom")))
        .andExpect(jsonPath("$[0].appointment_caretaker", is("Jane Doe")))
        .andExpect(jsonPath("$[0].appointment_price", is("100.99")));
    }

    @Test
    void testAddNewAppointment() throws Exception {
        uri = "/api/appointments/new";
        Appointment apt = new Appointment();
        mvc.perform(post(uri).content(asJsonString(apt)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void testUpdateAppointment() throws Exception {
        uri = "/api/appointments/update";
        Appointment apt = new Appointment();
        mvc.perform(put(uri).content(asJsonString(apt)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
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
*/