package com.einfo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.demo.entity.Complaint_Category;
import com.einfo.demo.entity.Employee;
import com.einfo.demo.service.Complaint_CategoryService;
import com.einfo.demo.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Complaint_CategoryService categoryService;
	
	@PostMapping("/save")
	
	public ResponseEntity<?> saveEmp(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(employeeService.save(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	//@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<?> getAllemp()
	{
		return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws Exception
	{
		return new ResponseEntity<>(employeeService.findSpecific(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable Long id)
	{
		return new ResponseEntity<>(employeeService.delete(id),HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editEmp(@RequestBody Employee emp, @PathVariable long id)
	{
		return new ResponseEntity<>(employeeService.edit(emp, id),HttpStatus.CREATED);
	}
	
	@GetMapping("/category/findAllActive")
	public ResponseEntity<?> findAllActive(){
		return new ResponseEntity<>(categoryService.getByStatus(0),HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> findByCategoryId(@PathVariable long categoryId)throws Exception
	{
		return new ResponseEntity<>(categoryService.findSpecific(categoryId),HttpStatus.OK);
	}
	
	@DeleteMapping("/category/delete/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable long categoryId)
	{
		return new ResponseEntity<>(categoryService.delete(categoryId),HttpStatus.OK);
	}
}
