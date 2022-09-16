/**
import org.junit.jupiter.api.Test;

package com.cognixia.jump;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognixia.jump.controller.PetInfoController;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.PetInfo;
import com.cognixia.jump.model.User;
//import com.cognixia.jump.model.Customer.Role;
import com.cognixia.jump.service.MyUserDetailsService;
import com.cognixia.jump.service.PetInfoService;
import com.cognixia.jump.util.JwtUtil;
//import com.cognixia.jump.exception.ResourceNotFoundException;
//import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PetInfoController.class)
public class PetInfoControllerTest {

	private final String STARTING_URI = "http://localhost:8080/api/";
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PetInfoService service;
	
	@MockBean
	private MyUserDetailsService service2;
	
	@MockBean
	private JwtUtil util;
	
	@InjectMocks
	private PetInfoController controller;
	
//	@Test
//	void testGetAllPets() throws Exception {
//		String uri = STARTING_URI + "petInfo";
//		List<PetInfo> testPets = new ArrayList<>();
//		
//		testPets.add(new PetInfo(1L, "Test Pet", 12, "Dog", "Poodle", false));
//		testPets.add(new PetInfo(2L, "Pet Test", 12, "Cat", "Ragdoll", true));
//		
//		when(service.getAllPetInfo()).thenReturn(testPets);
//		mvc.perform(get(uri)).andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		.andExpect(jsonPath("$.length()").value(testPets.size()))
//		.andExpect(jsonPath("$[0].pet_id").value(testPets.get(0).getPet_id()))
//		.andExpect(jsonPath("$[0].pet_name").value(testPets.get(0).getPet_name()))
//		.andExpect(jsonPath("$[0].pet_age").value(testPets.get(0).getPet_age()))
//		.andExpect(jsonPath("$[0].pet_type").value(testPets.get(0).getPet_type()))
//		.andExpect(jsonPath("$[0].pet_breed").value(testPets.get(0).getPet_breed()))
//		.andExpect(jsonPath("$[0].pet_is_vaccinated").value(testPets.get(0).getPet_is_vaccinated()))
//		.andExpect(jsonPath("$[1].pet_id").value(testPets.get(0).getPet_id()))
//		.andExpect(jsonPath("$[1].pet_name").value(testPets.get(0).getPet_name()))
//		.andExpect(jsonPath("$[1].pet_age").value(testPets.get(0).getPet_age()))
//		.andExpect(jsonPath("$[1].pet_type").value(testPets.get(0).getPet_type()))
//		.andExpect(jsonPath("$[1].pet_breed").value(testPets.get(0).getPet_breed()))
//		.andExpect(jsonPath("$[1].pet_is_vaccinated").value(testPets.get(0).getPet_is_vaccinated()));
//		
//		verify(service, times(1)).getAllPetInfo();
//		verifyNoMoreInteractions(service);
//	}
//
//    @Test
//    void testGetPet() throws Exception {
//        long pet_id = 1;
//        String uri = STARTING_URI + "petInfo/id/{pet_id}";
//		PetInfo pet = new PetInfo(1L, "Test Pet", 12, "Dog", "Poodle", false);
//
//        when(service.getPetById(pet_id)).thenReturn(pet);
//        mvc.perform(get(uri, pet_id)).andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		.andExpect(jsonPath("$.pet_id").value(pet.getPet_id()))
//		.andExpect(jsonPath("$.pet_name").value(pet.getPet_name()))
//		.andExpect(jsonPath("$.pet_age").value(pet.getPet_age()))
//		.andExpect(jsonPath("$.pet_type").value(pet.getPet_type()))
//		.andExpect(jsonPath("$.pet_breed").value(pet.getPet_breed()))
//		.andExpect(jsonPath("$.pet_is_vaccinated").value(pet.getPet_is_vaccinated()));
//
//		verify(service, times(1)).getPetById(pet_id);
//		verifyNoMoreInteractions(service);
//    }
}
 */