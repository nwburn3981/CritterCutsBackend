package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Appointment updateAppointment(Appointment appointment) {
		
		Appointment saved = repo.save(appointment);
		
		return saved;
	}
}







