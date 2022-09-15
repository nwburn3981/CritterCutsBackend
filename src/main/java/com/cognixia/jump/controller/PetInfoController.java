package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.PetInfo;
import com.cognixia.jump.service.PetInfoService;

@RequestMapping("/api")
@RestController
public class PetInfoController {

	@Autowired
	PetInfoService petService;
	
	@GetMapping("/petInfo")
	public List<PetInfo> getAllPets(){
		return petService.getAllPetInfo();
	}
	
	@GetMapping("/petInfo/id/{pet_id}")
	public PetInfo getPet(@PathVariable long pet_id) throws ResourceNotFoundException {
		return petService.getPetById(pet_id);
	}
	
	@PostMapping("/petInfo/add/petInfo")
	public ResponseEntity<PetInfo>createPetInfo(@Valid @RequestBody PetInfo petInfo){
		
		PetInfo added = petService.addPetInfo(petInfo);
		
		return new ResponseEntity<>(added, HttpStatus.CREATED);
	}
	
	@PutMapping("/petInfo/update/petInfo")
	public ResponseEntity<PetInfo> updatePetInfo(@Valid @RequestBody PetInfo petInfo) throws ResourceNotFoundException{
		PetInfo updated = petService.updatePetInfo(petInfo);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/petInfo/delete/{pet_id}")
	public ResponseEntity<PetInfo> removePet(@PathVariable long pet_id) throws ResourceNotFoundException{
		PetInfo deleted = petService.deletePetInfo(pet_id);
		
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@GetMapping("/petInfo/pet_customerid/{id}")
	public PetInfo findPetbyCustomerId(@PathVariable Long id) throws ResourceNotFoundException{
		return petService.findPetbyCustomerId(id);
	}
	
}
