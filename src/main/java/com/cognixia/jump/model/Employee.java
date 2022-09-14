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

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	public static enum Role {
		ROLE_USER, // roles should start with capital ROLE_ and has to be completely in capital
					// letters
		ROLE_ADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;

	@Column
	private String name;

	@Column
	private int salary;

	@Column
	private LocalDate dob;

	@Column
	private String specialty;

	@Column
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private List<Appointment> appointment;
	
	public Employee() {
		this(-1L, "", 0, LocalDate.now(), "", Role.ROLE_USER, new User());
	}

	public Employee(Long employee_id, String name, int salary, LocalDate dob, String specialty, Role role, User user) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.specialty = specialty;
		this.role = role;
		this.user = user;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", salary=" + salary + ", dob=" + dob
				+ ", specialty=" + specialty + ", role=" + role + ", user=" + user + "]";
	}

}
