package com.einfo.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.einfo.demo.entity.Complaint_Category;
import com.einfo.demo.repo.Complaint_CategoryRepo;
import com.einfo.demo.service.Complaint_CategoryService;

@Service
public class Complaint_CategoryServiceImpl implements Complaint_CategoryService{
	
	@Autowired
	private Complaint_CategoryRepo repo;

	@Override
	public Page<Complaint_Category> getAll(int pageNumber, int pageSize) {
		return  repo.findAll((PageRequest.of(pageNumber, pageSize)));
		// TODO Auto-generated method stub
		
	}

	@Override
	public Complaint_Category findSpecific(long id)throws Exception {
		// TODO Auto-generated method stub
		Complaint_Category category=repo.findById(id).get();
		if(category!=null) {
			return category;
		}else {
			throw new Exception("Id not present :"+id);
		}
		
		
		
	}

	@Override
	public List<Complaint_Category> getByStatus(int id) {
		// TODO Auto-generated method stub
	//	Complaint_Category category=repo.findByStatus(1);
		return repo.findByStatus(id);
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		Optional<Complaint_Category> optional=repo.findById(id);
		if(optional.isPresent()) 
		{
			Complaint_Category category=repo.findById(id).get();
			repo.delete(category);
			return"Category Deleted successfully!!!!";
		}else {
			return "Category id not present:"+id;
		}
		
	}

}
