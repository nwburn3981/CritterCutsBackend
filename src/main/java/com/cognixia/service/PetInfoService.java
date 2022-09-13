package com.cognixia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.PetInfo;
import com.cognixia.jump.repository.PetInfoRepository;

@Service
public class PetInfoService {
	
	@Autowired
	PetInfoRepository petRepo;
	
	public List<PetInfo> getAllPetInfo(){
		return petRepo.findAll();
	}
	
	public PetInfo getPetById(long pet_id){
		Optional<PetInfo> found = petRepo.findById(pet_id);
		if(!found.isPresent()) {
			return null;
		}
		return found.get();
	}
	
	public PetInfo addPetInfo(PetInfo petInfo) {
		petInfo.setPet_id(-1L);
		
		PetInfo saved = petRepo.save(petInfo);
		return saved;
	}
	
	public PetInfo updatePetInfo(PetInfo petInfo) {
		
		if(petRepo.existsById(petInfo.getPet_id())) {
			return null;
		}
		PetInfo updated = petRepo.save(petInfo);
		return updated;
	}
	
	public PetInfo deletePetInfo(long pet_id) {
		
		PetInfo toDelete = getPetById(pet_id);
		
		petRepo.deleteById(pet_id);
		
		return toDelete;
		
	}
	
}
