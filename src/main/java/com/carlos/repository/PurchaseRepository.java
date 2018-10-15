package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.entity.Purchase;

public interface PurchaseRepository  extends CrudRepository<Purchase, Long>{

}
