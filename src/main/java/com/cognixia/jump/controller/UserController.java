package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;

import com.cognixia.jump.model.AuthenticationRequest;
//import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api")
@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncoder encoder;

	@Operation(summary = "Find all users", description = "Finds every user in the database.")
	@ApiResponse(responseCode = "200", description = "All users have been found")
	@ApiResponse(responseCode = "400", description = "Users not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Operation(summary = "Finds the user by the id", description = "Searches the database for a user which has the id matching the one given by the uri")
	@ApiResponse(responseCode = "200", description = "User has been found")
	@ApiResponse(responseCode = "400", description = "User not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "User not found")
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable long id) {
		return repo.findById(id);
	}

	@Operation(summary = "Creates a new user", description = "Posts raw JSON data to be inserted into the database with all of the values needed to create a new user")
	@ApiResponse(responseCode = "201", description = "User has been created")
	@ApiResponse(responseCode = "400", description = "User not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/users/new")
	public User addNewUser(User user) {
		user.setUser_id(1L);

		User saved = repo.save(user);

		return saved;
	}

	@Operation(summary = "Updates an existing user", description = "Updates all fields in a user, puts JSON raw data that includes all pet information")
	@ApiResponse(responseCode = "200", description = "User updated")
	@ApiResponse(responseCode = "400", description = "User not updated")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PutMapping("/users/update")
	public User updateUser(User user) throws ResourceNotFoundException {

		if (!repo.existsById(user.getUser_id())) {
			throw new ResourceNotFoundException(
					"User with id = " + user.getUser_id() + " could not be found and cannot be updated.");
		}

		User saved = repo.save(user);

		return saved;
	}

	@Operation(summary = "Finds the user by username")
	@ApiResponse(responseCode = "201", description = "success")
	@ApiResponse(responseCode = "400", description = "failure")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/users/details")
	public ResponseEntity<?> getUserDetails(@RequestBody AuthenticationRequest request) {

		Optional<User> user = repo.findByUsername(request.getUsername());

		if (user.isEmpty()) {
			return ResponseEntity.status(404).body("User not found");
		} else {
			return ResponseEntity.status(200).body(user.get());
		}
	}

	@Operation(summary = "Deletes an existing user", description = "Removes an existing user from the database, the database will be searched for a user with a matching id and it will be removed from the database permanently")
	@ApiResponse(responseCode = "200", description = "User deleted")
	@ApiResponse(responseCode = "400", description = "User not deleted")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@DeleteMapping("/users/delete/{id}")
	public Optional<User> deleteUser(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

	//TODO: /create/user and /users/new enpoints serve the same purpose, remove one
	@Operation(summary = "Creates a new user", description = "Posts raw JSON data to be inserted into the database with all of the values needed to create a new user")
	@ApiResponse(responseCode = "201", description = "User has been created")
	@ApiResponse(responseCode = "400", description = "User not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/create/user")
	public ResponseEntity<?> createUser( @RequestBody User user ) {
		
		user.setUser_id(-1L);
		
		// will take the plain text password that we get in and encode it before it gets saved to the database
		// security isn't going to encode our passwords on its own
		user.setPassword( encoder.encode( user.getPassword() ) );
		
		User created = repo.save(user);
		
		return ResponseEntity.status(201).body(created);
		
	}
	

}
