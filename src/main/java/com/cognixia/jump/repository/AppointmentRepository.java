package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}
