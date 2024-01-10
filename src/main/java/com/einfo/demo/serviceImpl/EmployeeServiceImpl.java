package com.einfo.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.einfo.demo.entity.Employee;
import com.einfo.demo.repo.EmployeeRepo;
import com.einfo.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee findSpecific(long id) throws Exception {
		// TODO Auto-generated method stub
		Employee employee=repo.findById(id).get();
		if(employee!=null) {
			return employee;
		}else {
			throw new Exception("Product is not available for id :"+id);
		}
		
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		return repo.save(employee);
	}

	@Override
	public Employee edit(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee employee2=repo.findById(id).get();
		employee2.setEmail(employee.getEmail());
		employee2.setPassword(employee2.getPassword());
		employee2.setMobile(employee.getMobile());
		employee2.setName(employee.getName());
		employee2.setPhoto(employee.getPhoto());
		employee2.setStatus(employee.getStatus());
		employee2.setWorkingType(employee.getWorkingType());
		return repo.save(employee2);
	}

	@Override
	public String delete(long id) {
		Optional<Employee> optional=repo.findById(id);
		if(optional.isPresent()) {
			Employee employee=repo.findById(id).get();
			repo.delete(employee);
			return"Employee Deleted successfully!!!!";
		}else {
		return "Employee id not presenet:"+id;
			}
//		Employee employee = repo.findById(id).get();
//		if(employee!=null)
//		{
//			repo.delete(employee);
//			return"Employee Deleted successfully!!!!";
//		}else {
//			return "Employee id not presenet";
//		}
		// TODO Auto-generated method stub
		
	}

}
