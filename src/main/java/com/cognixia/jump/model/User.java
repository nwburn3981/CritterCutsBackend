package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static enum Role {
		ROLE_USER, // roles should start with capital ROLE_ and has to be completely in capital
					// letters
		ROLE_ADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;

	@Schema(description = "User's username", example = "username999", required = true)
	@Size(min = 1, max = 32)
	@Column
	private String username;

	@Schema(description = "User's password", example = "pw123", required = true)
	@Size(min = 3, max = 32)
	@Column
	private String password;

	@Column
	private boolean enabled;

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Customer customer;

	@Column
	private Long customer_id;

	// Once employee model is created this will be where it relates to User
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Employee employee;

	@Column
	private Long employee_id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
		this(-1L, "", "", false, Role.ROLE_USER);
	}

	public User(Long user_id, String username, String password, boolean enabled, Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getType() {
		if (this.employee != null)
			return "Employee";
		else
			return "Customer";
	}
	
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", customer=" + customer + ", customer_id=" + customer_id + ", employee=" + employee
				+ ", employee_id=" + employee_id + ", role=" + role + "]";
	}



}
