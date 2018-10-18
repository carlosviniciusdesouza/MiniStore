package com.carlos.service;

import com.carlos.entity.Product;

public interface ProductService {

	public boolean checkInventory(Product product, int quantity);

}
