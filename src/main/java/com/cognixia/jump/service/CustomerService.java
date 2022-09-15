package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	@Autowired
	UserService userService;

	public List<Customer> getAllPetInfo() {
		return repo.findAll();
	}

	public Customer getCustomerById(long customer_id) throws ResourceNotFoundException {
		Optional<Customer> found = repo.findById(customer_id);
		if (!found.isPresent()) {
			throw new ResourceNotFoundException("Customer with id = " + customer_id + " could not be found.");
		}
		return found.get();
	}

	public Customer addCustomerInfo(Customer customer, Long user_id) throws ResourceNotFoundException {

		customer.setCustomer_id(-1L);

		Customer saved = repo.save(customer);

		User user = userService.getUserById(user_id);
		user.setCustomer(customer);
		user.setCustomer_id(customer.getCustomer_id());
		userService.updateUser(user);

		return saved;
	}

	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {

		if (!repo.existsById(customer.getCustomer_id())) {
			throw new ResourceNotFoundException(
					"Pet with id = " + customer.getCustomer_id() + " could not be found and cannot be updated.");
		}
		Customer updated = repo.save(customer);
		return updated;
	}

	public Customer deleteCustomer(long customer_id) throws ResourceNotFoundException {

		Customer toDelete = getCustomerById(customer_id);

		repo.deleteById(customer_id);

		return toDelete;

	}

}
