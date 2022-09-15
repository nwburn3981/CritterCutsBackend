package com.cognixia.jump.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.service.CustomerService;
import com.cognixia.jump.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CustomerController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Operation(summary = "Finds the customer by the id", description = "Searches the database for a customer which has the id matching the one given by the uri")
	@ApiResponse(responseCode = "200", description = "Customer found")
	@ApiResponse(responseCode = "400", description = "Customers not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable long id) throws ResourceNotFoundException {
		return custService.getCustomerById(id);
	}
	
	@Operation(summary = "Creates a new customer", description = "Posts raw JSON data to be inserted into the database with all of the values needed to create a new customer")
	@ApiResponse(responseCode = "201", description = "Customer created successfully")
	@ApiResponse(responseCode = "400", description = "Customer not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/create/customer/{user_id}")
	public ResponseEntity<?> createCustomer( @RequestBody Customer customer, @PathVariable Long user_id ) throws ResourceNotFoundException {
		
		// will take the plain text password that we get in and encode it before it gets saved to the database
		// security isn't going to encode our passwords on its own
		customer.setPassword( encoder.encode( customer.getPassword() ) );
		
		Customer created = custService.addCustomerInfo(customer, user_id);
		
		return ResponseEntity.status(201).body(created);
		
	}
	
	
	
	
	
	
	
	
	
}
