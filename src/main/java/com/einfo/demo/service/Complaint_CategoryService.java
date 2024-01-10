package com.einfo.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.einfo.demo.entity.Complaint_Category;

public interface Complaint_CategoryService {
	
	Page<Complaint_Category> getAll(int pageNumber, int pageSize);
	Complaint_Category findSpecific(long id)throws Exception;
	List<Complaint_Category> getByStatus(int id);
	String delete(long id);

}
