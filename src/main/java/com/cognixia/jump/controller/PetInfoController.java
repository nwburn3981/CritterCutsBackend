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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api")
@RestController
public class PetInfoController {

	@Autowired
	PetInfoService petService;
	
	@Operation(summary = "Find all pets", description = "Finds every pet in the database.")
	@ApiResponse(responseCode = "200", description = "All pets have been found")
	@ApiResponse(responseCode = "400", description = "Pets not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@GetMapping("/petInfo")
	public List<PetInfo> getAllPets(){
		return petService.getAllPetInfo();
	}
	
	@Operation(summary = "Finds the pet by the id", description = "Searches the database for a pet which has the id matching the one given by the uri")
	@ApiResponse(responseCode = "200", description = "Pet has been found")
	@ApiResponse(responseCode = "400", description = "Pet not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Pet not found")
	@GetMapping("/petInfo/id/{pet_id}")
	public PetInfo getPet(@PathVariable long pet_id) throws ResourceNotFoundException {
		return petService.getPetById(pet_id);
	}
	
	@Operation(summary = "Creates a new pet", description = "Posts raw JSON data to be inserted into the database with all of the values needed to create a new pet")
	@ApiResponse(responseCode = "201", description = "Pet has been created")
	@ApiResponse(responseCode = "400", description = "Pet not created")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PostMapping("/petInfo/add/petInfo")
	public ResponseEntity<PetInfo>createPetInfo(@Valid @RequestBody PetInfo petInfo){
		
		PetInfo added = petService.addPetInfo(petInfo);
		
		return new ResponseEntity<>(added, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "Updates an existing pet", description = "Updates all fields in a pet, puts JSON raw data that includes all pet information")
	@ApiResponse(responseCode = "200", description = "Pet updated")
	@ApiResponse(responseCode = "400", description = "Pet not updated")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@PutMapping("/petInfo/update/petInfo")
	public ResponseEntity<PetInfo> updatePetInfo(@Valid @RequestBody PetInfo petInfo) throws ResourceNotFoundException{
		PetInfo updated = petService.updatePetInfo(petInfo);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@Operation(summary = "Deletes an existing pet", description = "Removes an existing pet from the database, the database will be searched for a pet with a matching id and it will be removed from the database permanently")
	@ApiResponse(responseCode = "200", description = "Pet deleted")
	@ApiResponse(responseCode = "400", description = "Pet not deleted")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@DeleteMapping("/petInfo/delete/{pet_id}")
	public ResponseEntity<PetInfo> removePet(@PathVariable long pet_id) throws ResourceNotFoundException{
		PetInfo deleted = petService.deletePetInfo(pet_id);
		
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@Operation(summary = "Finds a pet by the id of its owner", description = "The database will be searched for a pet that has a customer_id matching the id given and retrieves it")
	@ApiResponse(responseCode = "200", description = "Pet fetched, bow wow")
	@ApiResponse(responseCode = "400", description = "Pet not found")
	@ApiResponse(responseCode = "401", description = "Forbidden: unauthorized")
	@ApiResponse(responseCode = "403", description = "Forbidden: unauthorized 2: electric boogaloo")
	@ApiResponse(responseCode = "404", description = "Page not found")
	@ApiResponse(responseCode = "418", description = "fortnite")
	@ApiResponse(responseCode = "429", description = "STOP THAT")
	@GetMapping("/petInfo/pet_customerid/{id}")
	public PetInfo findPetbyCustomerId(@PathVariable Long id) throws ResourceNotFoundException{
		return petService.findPetbyCustomerId(id);
	}
	
}
