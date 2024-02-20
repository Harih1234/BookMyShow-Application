package com.springproject.bookmyshow.controller;

import java.util.List;

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

import com.springproject.bookmyshow.dto.UserDto;
 
import com.springproject.bookmyshow.entity.User;
import com.springproject.bookmyshow.service.UserService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userId) {
		return service.findUser(userId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userId) {
		return service.deleteUser(userId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user,@RequestParam int userId) {
		return service.updateUser(user, userId);
		
	}
	
//	@GetMapping("findall")
//	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUser() {
//		return service.findAllUsers();
//	}
	
}
