package com.carlos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PurchaseProductId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6609777133719864217L;

	@Column(name = "purchase_id")
	private Long purchaseId;

	@Column(name = "product_id")
	private Long productId;

	public PurchaseProductId(Long purchaseId, Long productId) {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((purchaseId == null) ? 0 : purchaseId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseProductId other = (PurchaseProductId) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (purchaseId == null) {
			if (other.purchaseId != null)
				return false;
		} else if (!purchaseId.equals(other.purchaseId))
			return false;
		return true;
	}	
}
