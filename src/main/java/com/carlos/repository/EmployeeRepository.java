package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.entity.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Long>{

}
