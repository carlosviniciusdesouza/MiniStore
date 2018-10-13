package com.carlos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct{

	@EmbeddedId
	private PurchaseProductId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("purchaseId")//TODO must give error, change to "productId or something
	private Purchase purchase;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")//TODO must give error, change to "productId or something
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	public PurchaseProduct(Purchase purchase, Product product, int quantity) {
		this.id = new PurchaseProductId(purchase.getId(), product.getId());
		this.purchase = purchase;
		this.product = product;
		this.quantity = quantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseProductId getId() {
		return id;
	}
	
}
