package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.Date;
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

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum Role {
		ROLE_USER	// roles should start with capital ROLE_ and has to be completely in capital letters
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customer_id;

	@Column
	private String customer_name;

	@Column
	private Date dob;

	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String customer_email;
	@Column
	//@Pattern(regexp = "^[0-9]{10}$")
	private int customer_phone;

	@Column
	private String username;

	@Column
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column( nullable = false )
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private User user;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<PetInfo> pets;
	
	public Customer(){
		this(-1L, "N/A", null, "N/A", 0, "N/A", "N/A", new User());
	}

	public Customer(Long customer_id, String customer_name, Date dOB,
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
		this.user = user;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public Date getDob() {
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

	public void setDOB(Date dob) {
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
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", dob=" + dob
				+ ", customer_email=" + customer_email + ", customer_phone=" + customer_phone + ", username=" + username
				+ ", password=" + password + "]";
	}

}