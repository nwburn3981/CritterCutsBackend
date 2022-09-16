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
import com.cognixia.jump.model.Appointment;
import com.cognixia.jump.repository.AppointmentRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/api")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentRepository repo;
	
	@Operation(summary = "Find all appointments", description = "Find every appointment in the database, including all appointments that have already concluded, are in operation, or have yet to arrive that are still in the database.")
	@ApiResponse(responseCode = "200", description = "All appointments have been found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointment(){
		return repo.findAll();
	}
	
	@Operation(summary = "Find a single appointment", description = "Find the appointment through the given appointment id, the database will be searched for an appointment with a matching id and all of the attributes of the appointment will be presented to the user.")
	@ApiResponse(responseCode = "200", description = "Appointment found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Appointment was not found")
	@GetMapping("/appointments/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable long id){
		return repo.findById(id);
	}
	
	@Operation(summary = "Create a new appointment", description = "Posts JSON raw data that includes all information that is needed to create an appointment")
	@ApiResponse(responseCode = "201", description = "Appointment created successfully")
	@ApiResponse(responseCode = "400", description = "Appointment not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/appointments/new")
	public Appointment addNewAppointment(Appointment appointment){
		appointment.setAppointment_id(-1L);
		
		Appointment saved = repo.save(appointment);
		
		return saved;
	}
	
	@Operation(summary = "Updates an existing appointment", description = "Updates all fields in an appointment, puts JSON raw data that includes all appointment information")
	@ApiResponse(responseCode = "200", description = "Appointment updated")
	@ApiResponse(responseCode = "400", description = "Appointment not updated")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PutMapping("/appointments/update")
	public Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException{
		
		if(repo.existsById(appointment.getAppointment_id())) {
			throw new ResourceNotFoundException("Appointment with id = " + appointment.getAppointment_id() 
				+ " could not be found and cannot be updated.");
		}
		
		Appointment saved = repo.save(appointment);
		
		return saved;
	}
	
	@Operation(summary = "Deletes an existing appointment", description = "Removes an existing appointment from the database, the database will be searched for an appointment with a matching id and it will be removed from the database permanently")
	@ApiResponse(responseCode = "200", description = "Appointment deleted")
	@ApiResponse(responseCode = "400", description = "Appointment not deleted")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@DeleteMapping("/appointments/delete/{id}")
	public Optional<Appointment> deleteAppoitment(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

	@Operation(summary = "Finds an appointment by the id of the pet", description = "The database will be searched for an appointment that has a pet_id matching the id given and retrieves it")
	@ApiResponse(responseCode = "200", description = "Appointment fetched, bow wow")
	@ApiResponse(responseCode = "400", description = "Appointment not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@ApiResponse(responseCode = "418", description = "sussus amogus")
	@ApiResponse(responseCode = "429", description = "STOP THAT")
	@GetMapping("/appointments/user/{id}")
	public Optional<Appointment> getAppointmentByPetId(@PathVariable Long id){
		return repo.findAppointmentByPetId(id);
	}
	
}







