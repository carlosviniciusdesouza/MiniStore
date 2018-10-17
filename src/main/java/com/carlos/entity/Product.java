package com.carlos.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", unique = true, length = 50, nullable = false)
	private String name;

	@Column(name = "type", length = 50)
	private String type;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "registrationDate", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Calendar registrationDate;

	@Column(name = "inventory", nullable = false)
	private int inventory;
	
	public Product(String name, double price, int inventory) {
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		registrationDate = Calendar.getInstance();
	}

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public Long getId() {
		return id;
	}
}
