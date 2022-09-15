package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class PetInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pet_id;

	@Schema(description = "The name of the pet", example = "Spot", required = true)
	@Size(min = 1, max = 100)
	@Column
	private String pet_name;

	@Schema(description = "Estimate of the pets age in years", example = "4", required = true)
	@Column
	private Integer pet_age;

	@Schema(description = "What species of animal it is", example = "Guinea Pig", required = true)
	@Column
	private String pet_type;

	@Schema(description = "What breed the animal is", example = "Abyssinian", required = true)
	@Column
	private String pet_breed;

	@Schema(description = "If the pet is vaccinated for rabies and other diseases", example = "false", required = true)
	@Column
	private Boolean pet_is_vaccinated;

	@Schema(description = "The pet's owner's id", example = "1", required = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = false, name = "pet_owner_id", referencedColumnName = "customer_id")
	@JsonIgnore
	private Customer owner;

	@Column
	private Long owner_id;

	public PetInfo() {
		this(-1L, "N/A", -1, "N/A", "N/A", false, new Customer());
	}

	public PetInfo(Long pet_id, String pet_name, Integer pet_age, String pet_type, String pet_breed,
			Boolean pet_is_vaccinated, Customer owner) {
		super();
		this.pet_id = pet_id;
		this.pet_name = pet_name;
		this.pet_age = pet_age;
		this.pet_type = pet_type;
		this.pet_breed = pet_breed;
		this.pet_is_vaccinated = pet_is_vaccinated;
		this.owner_id = owner.getCustomer_id();
	}

	public Long getPet_id() {
		return pet_id;
	}

	public void setPet_id(Long pet_id) {
		this.pet_id = pet_id;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public Integer getPet_age() {
		return pet_age;
	}

	public void setPet_age(Integer pet_age) {
		this.pet_age = pet_age;
	}

	public String getPet_type() {
		return pet_type;
	}

	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}

	public String getPet_breed() {
		return pet_breed;
	}

	public void setPet_breed(String pet_breed) {
		this.pet_breed = pet_breed;
	}

	public Boolean getPet_is_vaccinated() {
		return pet_is_vaccinated;
	}

	public void setPet_is_vaccinated(Boolean pet_is_vaccinated) {
		this.pet_is_vaccinated = pet_is_vaccinated;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "PetInfo [pet_id=" + pet_id + ", pet_name=" + pet_name + ", pet_age=" + pet_age + ", pet_type="
				+ pet_type + ", pet_breed=" + pet_breed + ", pet_is_vaccinated=" + pet_is_vaccinated + ", owner="
				+ owner + ", owner_id=" + owner_id + "]";
	}

}
