package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.PetInfo;

@Repository
public interface PetInfoRepository extends JpaRepository<PetInfo, Long>{

}
