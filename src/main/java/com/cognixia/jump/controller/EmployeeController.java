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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	
	
	@Operation(summary = "Find all Employees", description = "Finds every Employee in the database.")
	@ApiResponse(responseCode = "200", description = "All Employees have been found")
	@ApiResponse(responseCode = "400", description = "Employees not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	@Operation(summary = "Finds the Employee by the id", description = "Searches the database for an Employee which has the id matching the one given by the uri")
	@ApiResponse(responseCode = "200", description = "Employee has been found")
	@ApiResponse(responseCode = "400", description = "Employee not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Employee not found")
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id){
		return repo.findById(id);
	}
	
	@Operation(summary = "Creates a new employee", description = "Posts raw JSON data to be inserted into the database with all of the values needed to create a new employee")
	@ApiResponse(responseCode = "201", description = "Employee has been created")
	@ApiResponse(responseCode = "400", description = "Employee not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/employees/new")
	public Employee addNewEmployee(Employee employee){
		employee.setEmployee_id(-1L);
		
		Employee saved = repo.save(employee);
		
		return saved;
	}
	
	@Operation(summary = "Updates an existing employee", description = "Updates all fields in an employee, puts JSON raw data that includes all employee information")
	@ApiResponse(responseCode = "200", description = "Employee updated")
	@ApiResponse(responseCode = "400", description = "Employee not updated")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PutMapping("/employees/update")
	public Employee updateEmployee(Employee employee) throws ResourceNotFoundException{
		
		if(repo.existsById(employee.getEmployee_id())) {
			throw new ResourceNotFoundException("Employee with id = " + employee.getEmployee_id() 
				+ " could not be found and cannot be updated.");
		}
		
		Employee saved = repo.save(employee);
		
		return saved;
	}
	
	@Operation(summary = "Deletes an existing employee", description = "Removes an existing employee from the database, the database will be searched for an employee with a matching id and it will be removed from the database permanently")
	@ApiResponse(responseCode = "200", description = "Employee deleted")
	@ApiResponse(responseCode = "400", description = "Employee not deleted")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@DeleteMapping("/employees/delete/{id}")
	public Optional<Employee> deleteEmployee(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

}
