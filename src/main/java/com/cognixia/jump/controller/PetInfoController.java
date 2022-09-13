package com.cognixia.jump.controller;

import java.util.List;

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
	public PetInfo getPet(@PathVariable long pet_id) {
		return petService.getPetById(pet_id);
	}
	
	@PostMapping("/petInfo/add/petInfo")
	public ResponseEntity<PetInfo>createPetInfo(@Valid @RequestBody PetInfo petInfo){
		
		PetInfo added = petService.addPetInfo(petInfo);
		
		return new ResponseEntity<>(added, HttpStatus.CREATED);
	}
	
	@PutMapping("/petInfo/update/petInfo")
	public ResponseEntity<PetInfo> updatePetInfo(@Valid @RequestBody PetInfo petInfo){
		PetInfo updated = petService.updatePetInfo(petInfo);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/petInfo/delete/{pet_id}")
	public ResponseEntity<PetInfo> removePet(@PathVariable long pet_id){
		PetInfo deleted = petService.deletePetInfo(pet_id);
		
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
	
}
