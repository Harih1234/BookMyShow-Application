package com.springproject.bookmyshow.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.entity.Admin;

import com.springproject.bookmyshow.service.AdminService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}
	@GetMapping("adminlogin")
	public  ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String adminMail,@RequestParam String adminPassword){
		return service.loginAdmin(adminMail, adminPassword);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findLaptop(@RequestParam int adminId) {
		return service.findAdmin(adminId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam int adminId) {
		return service.deleteAdmin(adminId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody Admin admin,@RequestParam int adminId) {
		return service.updateAdmin(admin, adminId);
	}
//	@GetMapping
//	public ResponseEntity<ResponseStructure<AdminDto>> findAll() {
//		return service.findAdmi)
//	}
	
	@PutMapping("assignTheatre")
	public ResponseEntity<ResponseStructure<Admin>> assignTheatreUsingAdminId(@RequestParam int theatreId ,@RequestParam int adminId) {
		return service.assignTheatreUsingAdminId(adminId, theatreId);
//		service.assignTheatreUsingAdminId(adminId, theatreId);
//		return service.saveAdmin(admin);
		
				
	}
	
//	@GetMapping("findall")
//	public ResponseEntity<ResponseStructure<List<AdminDto>>> findAllAdmin() {
//		return service.findAllAdmins();
//	}
}
