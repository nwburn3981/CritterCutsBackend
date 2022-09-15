package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.PetInfo;
import com.cognixia.jump.repository.PetInfoRepository;

@Service
public class PetInfoService {
	
	@Autowired
	PetInfoRepository petRepo;
	
	public List<PetInfo> getAllPetInfo(){
		return petRepo.findAll();
	}
	
	public PetInfo getPetById(long pet_id) throws ResourceNotFoundException{
		Optional<PetInfo> found = petRepo.findById(pet_id);
		if(!found.isPresent()) {
			throw new ResourceNotFoundException("Pet with id = " +pet_id + " could not be found.");
		}
		return found.get();
	}
	
	public PetInfo addPetInfo(PetInfo petInfo) {
		petInfo.setPet_id(-1L);
		
		PetInfo saved = petRepo.save(petInfo);
		return saved;
	}
	
	public PetInfo updatePetInfo(PetInfo petInfo) throws ResourceNotFoundException{
		
		if(!petRepo.existsById(petInfo.getPet_id())) {
			throw new ResourceNotFoundException("Pet with id = " + petInfo.getPet_id()
					+ " could not be found and cannot be updated.");
		}
		PetInfo updated = petRepo.save(petInfo);
		return updated;
	}
	
	public PetInfo deletePetInfo(long pet_id) throws ResourceNotFoundException{
		
		PetInfo toDelete = getPetById(pet_id);
		
		petRepo.deleteById(pet_id);
		
		return toDelete;
		
	}
	
	public PetInfo findPetbyCustomerId(Long id) throws ResourceNotFoundException{
		
		Optional<PetInfo> found = petRepo.findById(id);
		if(!found.isPresent()) {
			throw new ResourceNotFoundException("Pet with id = " + id + " could not be found.");
		}
		return found.get();

	}
	
}
