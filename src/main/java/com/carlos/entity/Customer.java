package com.carlos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class Customer {
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "email", unique=true, length = 50, nullable = false)
	private String email;
	
	@Column(name = "registrationDate", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate registrationDate;
	
	@Column(name = "username", length = 80)
	private String address;
}
