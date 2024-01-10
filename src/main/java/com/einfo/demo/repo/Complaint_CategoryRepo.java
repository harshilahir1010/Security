package com.einfo.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einfo.demo.entity.Complaint_Category;

public interface Complaint_CategoryRepo extends JpaRepository<Complaint_Category, Long>{
	
	List<Complaint_Category> findByStatus(int status);

}
