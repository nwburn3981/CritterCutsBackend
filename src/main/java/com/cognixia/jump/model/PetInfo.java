package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PetInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pet_id;
	
	@Column
	private String pet_name;
	
	@Column
	private Integer pet_age;
	
	@Column
	private String pet_type;
	
	@Column
	private String pet_breed;
	
	@Column
	private Boolean pet_is_vaccindated;
	
	public PetInfo() {
		this(-1, "N/A", -1, "N/A", "N/A", false);
	}

	public PetInfo(Long pet_id, String pet_name, Integer pet_age, String pet_type, String pet_breed,
			Boolean pet_is_vaccindated) {
		super();
		this.pet_id = pet_id;
		this.pet_name = pet_name;
		this.pet_age = pet_age;
		this.pet_type = pet_type;
		this.pet_breed = pet_breed;
		this.pet_is_vaccindated = pet_is_vaccindated;
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

	public Boolean getPet_is_vaccindated() {
		return pet_is_vaccindated;
	}

	public void setPet_is_vaccindated(Boolean pet_is_vaccindated) {
		this.pet_is_vaccindated = pet_is_vaccindated;
	}

	@Override
	public String toString() {
		return "PetInfo [pet_id=" + pet_id + ", pet_name=" + pet_name + ", pet_age=" + pet_age + ", pet_type="
				+ pet_type + ", pet_breed=" + pet_breed + ", pet_is_vaccindated=" + pet_is_vaccindated + "]";
	};

	
	

	

}
