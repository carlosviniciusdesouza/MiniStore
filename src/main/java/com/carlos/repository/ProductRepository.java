package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.entity.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{
	
	//public Product findById();

}
