package com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.carlos.entity.Product;
import com.carlos.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@PreAuthorize("hasRole('SELLER') or hasRole('ADMIN')")
	public boolean checkInventory(Product product, int quantity) {
		return productRepository.findById(product.getId()).get().getInventory() >= quantity; //TODO make it readable
	}

}
