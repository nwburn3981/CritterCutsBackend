package com.cognixia.jump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cognixia.jump.model.AuthenticationRequest;
import com.cognixia.jump.model.AuthenticationResponse;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;
import com.cognixia.jump.util.JwtUtil;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CustomerComtroller {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/create/customer")
	public ResponseEntity<?> createUser( @RequestBody Customer user ) {
		
		user.setCustomer_id(null);
		
		// will take the plain text password that we get in and encode it before it gets saved to the database
		// security isn't going to encode our passwords on its own
		user.setPassword( encoder.encode( user.getPassword() ) );
		
		Customer created = custRepo.save(user);
		
		return ResponseEntity.status(201).body(created);
		
	}
	
	
	
	
	
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJwtToken(@RequestBody AuthenticationRequest request) throws Exception {
		
		// try to catch the exception for bad credentials, just so we can set our own
		// message when this doesn't work
		try {
			// make sure we have a valid user by checking their username and password
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (BadCredentialsException e) {
			// provide our own message on why login didn't work
			throw new Exception("Incorrect username or password");
		}

		// as long as no exception was thrown, user is valid

		// load in the user details for that user
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

		// generate the token for that user
		final String jwt = jwtUtil.generateTokens(userDetails);

		// return the token
		return ResponseEntity.status(201).body( new AuthenticationResponse(jwt) );

	}
	
}
