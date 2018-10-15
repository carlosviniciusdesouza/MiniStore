package com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.repository.PurchaseRepository;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public long countPurchaseTotal() {
		return purchaseRepository.count();
	}
}
