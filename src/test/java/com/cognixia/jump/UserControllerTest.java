//package com.cognixia.jump;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.cognixia.jump.controller.UserController;
//import com.cognixia.jump.model.User;
//import com.cognixia.jump.model.User.Role;
//import com.cognixia.jump.service.UserService;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//	
//	private final String STARTING_URI = "http://localhost:8080/api/";
//	
//	@Autowired
//	private MockMvc mvc;
//	
//
//	@MockBean
//	private UserService service;
//	
//	@InjectMocks
//	private UserController controller;
//	
//	@Test
//	void testGetAllCars() throws Exception {
//		String uri = STARTING_URI + "/users/{id}";
//		
//		List<User> testUsers = new ArrayList<>();
//		
//		testUsers.add(new User(1L, "User1", "123", true, Role.ROLE_USER));
//		testUsers.add(new User(2L, "User2", "456", false, Role.ROLE_USER));
//
//		when(service.getUserById(long)).thenReturn(testUsers);
//		
//		mvc.perform(get(uri))
//					.andDo(print())
//					.andExpect(status().isOk())
//					.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//					.andExpect(jsonPath("$.length").value(testUsers.size()))
//					
//					.andExpect(jsonPath("$[0].user_id").value(testUsers.get(0).getUser_id()))
//					.andExpect(jsonPath("$[0].username").value(testUsers.get(0).getUsername()))
//					.andExpect(jsonPath("$[0].password").value(testUsers.get(0).getUsername()))
//					.andExpect(jsonPath("$[0].enabled").value(testUsers.get(0).isEnabled()))
//					.andExpect(jsonPath("$[0].role").value(testUsers.get(0).getRole()))
//					
//					.andExpect(jsonPath("$[1].user_id").value(testUsers.get(1).getUser_id()))
//					.andExpect(jsonPath("$[1].username").value(testUsers.get(1).getUsername()))
//					.andExpect(jsonPath("$[1].password").value(testUsers.get(1).getUsername()))
//					.andExpect(jsonPath("$[1].enabled").value(testUsers.get(1).isEnabled()))
//					.andExpect(jsonPath("$[1].role").value(testUsers.get(1).getRole()));
//		
//		verify(service, times(1)).getUserById(1L);
//		verify(service, times(1)).getUserById(2L);
//		verifyNoMoreInteractions(service);
//	}
//}
