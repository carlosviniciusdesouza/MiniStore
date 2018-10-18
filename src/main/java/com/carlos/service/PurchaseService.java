package com.carlos.service;

import java.util.List;
import java.util.Map;

import com.carlos.entity.Customer;
import com.carlos.entity.Employee;
import com.carlos.entity.Product;
import com.carlos.entity.Purchase;
import com.carlos.entity.PurchaseProduct;

public interface PurchaseService {
	
	//public Purchase makePurchase(Customer customer, Product product, int quantity) throws Exception; TODO get logged employee
	//public Purchase makePurchase(Employee employee, Customer customer, Product product, int quantity) throws Exception;
	public Purchase makePurchase(Employee employee, Customer customer, Map<Product, Integer> products) throws Exception;

}
