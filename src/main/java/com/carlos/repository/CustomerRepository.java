package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Long>{

}
