package com.springproject.bookmyshow.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.repo.AdminRepo;
import com.springproject.bookmyshow.repo.TheatreRepo;

@Repository
public class AdminDao {

	@Autowired
	AdminRepo arepo;
	@Autowired
	TheatreRepo trepo;
	
	public Admin saveAdmin(Admin admin) {
		return arepo.save(admin);
		
	}
	
	public Admin loginAdmin(String adminMail,String adminPassword) {
		Admin admin = arepo.loginAdmin(adminMail);
		if(admin.getAdminMail() != null) {
			if(admin.getAdminPassword().equals(adminPassword)) {
				return admin;
			}
			return null;
		}
		return null;
	}
	
	public Admin findAdmin(int adminId) {
		Optional<Admin> opAdmin = arepo.findById(adminId);
		if(opAdmin.isPresent()) {
			return opAdmin.get();
		}
	return null;
	}
	
	public Admin deleteAdmin(int adminId) {
		Admin admin = findAdmin(adminId);
		arepo.delete(admin);
		return admin;
	}
	
	
	public Admin updateAdmin(Admin admin,int adminId) {
		Admin exAdmin = findAdmin(adminId);
		if(exAdmin != null) {
			admin.setAdminId(adminId);
			return arepo.save(admin);
		}
			return null;
		
	
	}
	
//	public List<Admin> findAllAdmin() {
//		return arepo.findAll();
//	}
	
	public Admin assignTheatreUsingAdminId(Admin admin,Theatre theatre,int theatreId,int adminId) {
		
		Admin admins = arepo.getById(adminId);
		Theatre theatres = trepo.getById(theatreId);
		
		admins.getTheatre().set(adminId, theatres);
		return arepo.save(admin);
		
	}
}
