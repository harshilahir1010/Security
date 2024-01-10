package com.einfo.demo.service;

import java.util.List;

import com.einfo.demo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findSpecific(long id)throws Exception;
	Employee save(Employee employee);
	Employee edit(Employee employee,long id);
	String delete(long id);

}
