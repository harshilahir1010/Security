package com.einfo.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einfo.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
	
	Optional<Employee> findByName(String name);

}
