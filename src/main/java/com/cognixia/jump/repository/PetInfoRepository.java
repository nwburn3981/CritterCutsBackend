package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.PetInfo;

@Repository
public interface PetInfoRepository extends JpaRepository<PetInfo, Long>{

	@Query(value="SELECT * FROM pet_info WHERE pets_customer_id = ?1", nativeQuery=true)
	public Optional<PetInfo> findPetbyCustomerId(Long id);
	
}
