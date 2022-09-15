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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;

	@Schema(description = "Employee's name", example = "Jane Doe", required = true)
	@Column
	private String name;

	@Schema(description = "Employee's annual salary in USD", example = "45000", required = true)
	@Column
	private int salary;

	@Schema(description = "Local Date of employee's birth (YYYY-MM-DD)", example = "1980-02-29", required = true)
	@Column
	private LocalDate dob;

	@Schema(description = "What types of pets the employee specializes in", example = "Exotic animals, cats", required = true)
	@Column
	private String specialty;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	@JsonIgnore
	private User user;

	@Column
	private Long user_id;

	@Schema(description = "A list of appointments the employee has with customer's pets", required = true)
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Appointment> appointment;

	public Employee() {
		this(-1L, "", 0, LocalDate.now(), "", new User());
	}

	public Employee(Long employee_id, String name, int salary, LocalDate dob, String specialty, User user) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.specialty = specialty;
		this.user_id = user.getUser_id();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", salary=" + salary + ", dob=" + dob
				+ ", specialty=" + specialty + ", user=" + user + ", user_id=" + user_id
				+ ", appointment=" + appointment + "]";
	}

}
