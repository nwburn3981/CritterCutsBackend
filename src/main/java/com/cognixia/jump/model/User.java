package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private boolean enabled;
	
	@OneToOne(mappedBy = "user")
	private Customer customer;
	
	//Once employee model is created this will be where it relates to User
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique = true)
//	private Employee employee;

	public User(Long user_id, String username, String password, boolean enabled, Customer customer) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.customer = customer;
	}

	public Long getUser_id() {
		return user_id;
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

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", customer=" + customer + "]";
	}
	


}
