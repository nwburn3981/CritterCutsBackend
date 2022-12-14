package com.cognixia.jump.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customer_id;

	@Schema(description = "Name of the customer", example = "John Doe", required = true)
	@Column
	private String customer_name;

	@Schema(description = "Local Date of birth of the customer (YYYY-MM-DD)", example = "2000-10-01", required = true)
	@Column
	private LocalDate dob;

	@Schema(description = "Customer's email with regex pattern for email addresses", example = "useremailaddress123@fakemail.com", required = true)
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String customer_email;

	@Schema(description = "Customer's phone number", example = "8005551234", required = true)
	@Size(min = 10, max = 10)
	@Column
	// @Pattern(regexp = "^[0-9]{10}$")
	private int customer_phone;

	@Schema(description = "Customer's username", example = "username123", required = true)
	@Size(min = 1, max = 32)
	@Column
	private String username;

	@Schema(description = "Customer's secret password", example = "pw123", required = true)
	@Size(min = 3, max = 32)
	@Column
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	@JsonIgnore
	private User user;

	@Column
	private Long user_id;

	@Schema(description = "The pets the customer owns", required = true)
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<PetInfo> pets;

	public Customer() {
		this(-1L, "N/A", null, "N/A", 0, "N/A", "N/A", new User());
	}

	public Customer(Long customer_id, String customer_name, LocalDate dOB,
			@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") String customer_email,
			@Pattern(regexp = "^[0-9]{10}$") int customer_phone, String username, String password, User user) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.dob = dOB;
		this.customer_email = customer_email;
		this.customer_phone = customer_phone;
		this.username = username;
		this.password = password;
		this.user_id = user.getUser_id();
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public int getCustomer_phone() {
		return customer_phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public void setDOB(LocalDate dob) {
		this.dob = dob;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public void setCustomer_phone(int customer_phone) {
		this.customer_phone = customer_phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PetInfo> getPets() {
		return pets;
	}

	public void setPets(List<PetInfo> pets) {
		this.pets = pets;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", dob=" + dob
				+ ", customer_email=" + customer_email + ", customer_phone=" + customer_phone + ", username=" + username
				+ ", password=" + password + ", user=" + user + ", user_id=" + user_id + ", pets=" + pets + "]";
	}

}