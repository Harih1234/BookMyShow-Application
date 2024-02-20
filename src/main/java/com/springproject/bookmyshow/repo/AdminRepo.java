package com.springproject.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springproject.bookmyshow.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	
	@Query("select a from Admin a where a.adminMail=?1")
	public Admin loginAdmin(String adminMail);
}
