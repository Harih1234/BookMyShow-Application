package com.springproject.bookmyshow.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.AdminDao;
import com.springproject.bookmyshow.dao.TheatreDao;
import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.exception.AdminNotFound;
import com.springproject.bookmyshow.exception.InvalidAdminLogin;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class AdminService {

//	@Autowired
//	AdminRepo arepo;
	
	@Autowired
	AdminDao adao;
	
	@Autowired
	TheatreDao tdao;
	
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin){
		Admin newadmin = adao.saveAdmin(admin);
		AdminDto dto=new AdminDto();
		
		ModelMapper mapper = new ModelMapper();
		mapper.map(adao.saveAdmin(admin), dto);
		
		ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Admin Saved");
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String adminMail,String adminPassword){
		Admin adm = adao.loginAdmin(adminMail, adminPassword);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		if(adm != null) {
			if(adm.getAdminMail()!= null) {
				if(adm.getAdminPassword().equals(adminPassword)) {
					structure.setData(adm);
					structure.setMessage("login Succesfull");
					structure.setStatus(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
				}
				throw new InvalidAdminLogin("Invalid Login Credentials");
			}
			throw new InvalidAdminLogin("Invalid Login Credentials");
			
		}
		throw new AdminNotFound("Manager Not Found");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int AdminId){
		Admin admin = adao.findAdmin(AdminId);
		AdminDto dto = new AdminDto();
		
		if(admin != null) {
			ModelMapper mapper = new ModelMapper();
			mapper.map(adao.findAdmin(AdminId),dto);
			
			ResponseStructure<AdminDto> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Admin Found");
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
		}
		throw new AdminNotFound("Admin not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int AdminId) {
		Admin admin = adao.findAdmin(AdminId);
		AdminDto dto = new AdminDto();
		ModelMapper mapper = new ModelMapper();
		
		
		if(admin !=null){
			
			mapper.map(adao.deleteAdmin(AdminId), dto);
				ResponseStructure<AdminDto> structure = new ResponseStructure<>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("admin deleted");
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Admin not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin,int adminId) {
		
		AdminDto dto = new AdminDto();
		//Admin ad = adao.updateAdmin(exadmin, adminId);
		
		ModelMapper mapper = new ModelMapper();
		mapper.map(adao.updateAdmin(admin, adminId), dto);
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Admin exadmin =adao.updateAdmin(admin, adminId);
		
		if(exadmin !=null) {
			
			
			structure.setMessage("admin updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
		}
		throw new AdminNotFound("admin not found for the given id in update");
	}
	
//	public ResponseEntity<ResponseStructure<List<AdminDto>>> findAllAdmins(){
//		List<Admin> admin = adao.findAllAdmin();
//		List<AdminDto> dto = adao.findAllAdmin();
//		
//		ModelMapper mapper = new ModelMapper();
//		mapper.map(admin, dto);
//		
//		
//			ResponseStructure<List<AdminDto>> structure = new ResponseStructure<List<AdminDto>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Admin");
//			structure.setData(dto);
//			return new ResponseEntity<ResponseStructure<List<AdminDto>>>(structure,HttpStatus.FOUND);
//}
	
	public ResponseEntity<ResponseStructure<Admin>> assignTheatreUsingAdminId(int adminId,int theatreId){
		Admin adm = adao.findAdmin(adminId);
		Theatre theatre = tdao.findTheatre(theatreId);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		
		if(adm!=null) {
			if(theatre != null) {
				adm.getTheatre().add(theatre);
				structure.setData(adao.updateAdmin(adm, adminId));
				structure.setMessage("Theatre Assigned to Admin");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
				
			}
			return null;
		}	
		return null;
	}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		Theatre extheatre = tdao.findTheatre(theatreId);
//		Admin adm = adao.findAdmin(adminId);
//		AdminDto dto = new AdminDto();
//		ModelMapper mapper = new ModelMapper();
//		mapper.map(adm, extheatre);
//	
//		if(extheatre != null) {
//			Theatre theatre =tdao.assignTheatreUsingAdminId(theatreId, adminId);
//			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
//			structure.setStatus(theatreId);
//			structure.setMessage("Theatre asiigned to admin");
//			structure.setData(theatre);
//			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
//		}
//		throw new AdminNotFound("Theatre doesn't available");
//	}

}
