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

@RequestMapping("/api")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentRepository repo;
	
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointment(){
		return repo.findAll();
	}
	
	@GetMapping("/appointments/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable long id){
		return repo.findById(id);
	}
	
	@PostMapping("/appointments/new")
	public Appointment addNewAppointment(Appointment appointment){
		appointment.setAppointment_id(-1L);
		
		Appointment saved = repo.save(appointment);
		
		return saved;
	}
	
	@PutMapping("/appointments/update")
	public Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException{
		
		if(repo.existsById(appointment.getAppointment_id())) {
			throw new ResourceNotFoundException("Appointment with id = " + appointment.getAppointment_id() 
				+ " could not be found and cannot be updated.");
		}
		
		Appointment saved = repo.save(appointment);
		
		return saved;
	}
	
	@DeleteMapping("/appointments/delete/{id}")
	public Optional<Appointment> deleteAppoitment(@PathVariable Long id) {
		repo.deleteById(id);
		return repo.findById(id);
	}

	@GetMapping("/appointments/user/{id}")
	public Optional<Appointment> getAppointmentByPetId(@PathVariable Long id){
		return repo.findById(id);
	}
	
}







