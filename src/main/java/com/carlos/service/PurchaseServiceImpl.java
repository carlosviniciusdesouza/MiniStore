package com.carlos.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.carlos.entity.Customer;
import com.carlos.entity.Employee;
import com.carlos.entity.Product;
import com.carlos.entity.Purchase;
import com.carlos.entity.PurchaseProduct;
import com.carlos.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	private static final String CASH = "Cash";

	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	ProductService productService;
	
	@PreAuthorize("hasRole('SELLER') or hasRole('ADMIN')")
	public Purchase makePurchase(Employee employee, Customer customer, Map<Product, Integer> products) throws Exception{
		
		return null;
		/*for (PurchaseProduct pp : products) {
			Product product = pp.getProduct();
			if(!productService.checkInventory(product, pp.getQuantity())) {
				throw new Exception("The product " + product.getName() + " has not enough in stock");
			}	
		}
		Purchase purchase = new Purchase(employee.getId(), customer.getId(), CASH);
		purchase.setPurchaseProduct(products);
		return purchaseRepository.save(purchase);*/
	}
	
	 @PreAuthorize("isAuthenticated()")
	 public List<PurchaseProduct> createCart() {
		return null;
	}
}
