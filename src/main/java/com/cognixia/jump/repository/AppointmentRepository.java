package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
	@Query(value="select * from appointment where pet_id = ?1", nativeQuery=true)
	public Optional<Appointment> findAppointmentByPetId(Long id);
	
}
