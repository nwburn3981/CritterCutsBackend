package com.cognixia.jump.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id;

    @Column(nullable = false)
    private LocalDate appointment_date;

    @Column(nullable = false)
    private LocalTime appointment_time;

    @Column
    private String appointment_service;

    @Column  
    private String appointment_caretaker;

    @Column
    private Double appointment_price;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = false, name = "pet_id")
    private PetInfo pet;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = false, name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    public Appointment() {
        this(-1L, LocalDate.now(), LocalTime.now(), "N/A", "N/A", 0.00);
    }

    public Appointment(Long appointment_id, LocalDate appointment_date, LocalTime appointment_time,
            String appointment_service, String appointment_caretaker, Double appointment_price) {
        super();
        this.appointment_id = appointment_id;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.appointment_service = appointment_service;
        this.appointment_caretaker = appointment_caretaker;
        this.appointment_price = appointment_price;
    }

    public Long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Long appointment_id) {
        this.appointment_id = appointment_id;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }

    public LocalTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_service() {
        return appointment_service;
    }

    public void setAppointment_service(String appointment_service) {
        this.appointment_service = appointment_service;
    }

    public String getAppointment_caretaker() {
        return appointment_caretaker;
    }

    public void setAppointment_caretaker(String appointment_caretaker) {
        this.appointment_caretaker = appointment_caretaker;
    }

    public Double getAppointment_price() {
        return appointment_price;
    }

    public void setAppointment_price(Double appointment_price) {
        this.appointment_price = appointment_price;
    }

	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", appointment_date=" + appointment_date
				+ ", appointment_time=" + appointment_time + ", appointment_service=" + appointment_service
				+ ", appointment_caretaker=" + appointment_caretaker + ", appointment_price=" + appointment_price + "]";
	}
    
}
