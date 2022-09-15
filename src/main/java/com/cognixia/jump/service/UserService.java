package com.cognixia.jump.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public User getUserById(long user_id) throws ResourceNotFoundException{
		Optional<User> found = repo.findById(user_id);
		if(!found.isPresent()) {
			throw new ResourceNotFoundException("User with id = " + user_id + " could not be found.");
		}
		return found.get();
	}

	public User updateUser(User user) throws ResourceNotFoundException {

		if (!repo.existsById(user.getUser_id())) {
			throw new ResourceNotFoundException(
					"User with id = " + user.getUser_id() + " could not be found and cannot be updated.");
		}
		User updated = repo.save(user);
		return updated;
	}

}
