package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@RequestMapping("/api")
@RestController
public class UserController {

	@Autowired
	UserRepository repo;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable long id) {
		return repo.findById(id);
	}

	@PostMapping("/users/new")
	public User addNewUser(User user) {
		user.setUser_id(1L);

		User saved = repo.save(user);

		return saved;
	}

	@PutMapping("/users/update")
	public User updateUser(User user) throws ResourceNotFoundException {

		if (repo.existsById(user.getUser_id())) {
			throw new ResourceNotFoundException(
					"User with id = " + user.getUser_id() + " could not be found and cannot be updated.");
		}

		User saved = repo.save(user);

		return saved;
	}

	@PostMapping("/users/details")
	public ResponseEntity<?> getUserDetails(@RequestBody AuthenticationRequest request) {

		Optional<User> user = repo.findByUsername(request.getUsername());

		if (user.isEmpty()) {
			return ResponseEntity.status(404).body("User not found");
		} else {
			return ResponseEntity.status(200).body(user.get());
		}
	}

	@DeleteMapping("/users/delete/{id}")
	public Optional<User> deleteUser(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

}
