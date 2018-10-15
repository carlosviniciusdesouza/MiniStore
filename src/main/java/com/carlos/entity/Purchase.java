package com.carlos.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "purchase")
public class Purchase {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "employee_id", unique=true, length = 50, nullable = false)
	private Long employeeId;

	@Column(name = "customer_id", unique=true, length = 50, nullable = false)
	private Long customerId;

	@Column(name = "paymentType", length = 50)
	private String paymentType;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "purchaseDate", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Calendar purchaseDate;

	@OneToMany(
			mappedBy = "purchase", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true
			)
	private List<PurchaseProduct> purchaseProduct;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Calendar getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getId() {
		return id;
	}

	public List<PurchaseProduct> getPurchaseProduct() {
		return purchaseProduct;
	}

	public void setPurchaseProduct(ArrayList<PurchaseProduct> purchaseProduct) {
		this.purchaseProduct = purchaseProduct;
	}
}

