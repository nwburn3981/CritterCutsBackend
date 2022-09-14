package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Employee;
import com.cognixia.jump.repository.EmployeeRepository;

@RequestMapping("/api")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id){
		return repo.findById(id);
	}
	
	@PostMapping("/employees/new")
	public Employee addNewEmployee(Employee employee){
		employee.setEmployee_id(-1L);
		
		Employee saved = repo.save(employee);
		
		return saved;
	}
	
	@PutMapping("/employees/update")
	public Employee updateEmployee(Employee employee) throws ResourceNotFoundException{
		
		if(repo.existsById(employee.getEmployee_id())) {
			throw new ResourceNotFoundException("Employee with id = " + employee.getEmployee_id() 
				+ " could not be found and cannot be updated.");
		}
		
		Employee saved = repo.save(employee);
		
		return saved;
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public Optional<Employee> deleteEmployee(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

}
