package com.cognixia.jump.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Customer {
	
	private int customer_id;
	private String customer_name;
	private Date DOB;
	private String customer_email;
	private int customer_phone;
	private String username;
	private String password;
	
}
