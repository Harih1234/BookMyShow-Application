
package com.springproject.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.TheatreDao;
import com.springproject.bookmyshow.dao.UserDao;
import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.dto.UserDto;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.entity.User;
import com.springproject.bookmyshow.exception.UserListNotFound;
import com.springproject.bookmyshow.exception.UserNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class UserService {

//	@Autowired
//	TheatreDao tdao;
	
	@Autowired
	UserDao udao;
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user){
		User newUser = udao.saveUser(user);
		UserDto dto=new UserDto();
		
		ModelMapper mapper = new ModelMapper();
		mapper.map(udao.saveUser(user),dto);
		
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("User Saved");
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(int userId){
		User user = udao.findUser(userId);
		UserDto dto = new UserDto();
		
		if(user != null) {
			ModelMapper mapper = new ModelMapper();
			mapper.map(user, dto);
			
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User Found");
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
		}
		throw new UserNotFound("User not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userId) {
		User user = udao.findUser(userId);
		UserDto dto = new UserDto();
		
		
		if(user !=null){
			User  newUser = udao.deleteUser(userId);
			
			ModelMapper mapper = new ModelMapper();
			mapper.map(newUser, dto);
				ResponseStructure<UserDto> structure = new ResponseStructure<>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("user deleted");
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
			}
			throw new UserNotFound("User not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user,int userId) {
		User use =udao.updateUser(userId, user);
		UserDto dto = new UserDto();
		
		ModelMapper mapper = new ModelMapper();
		mapper.map(udao.updateUser(userId, user),dto);
		if(use !=null) {
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("admin updated");
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		throw new UserNotFound("User not found for the given id in update");
	}
	
//	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers(){
//		List<User> user = udao.findAllUser();
//		
//		List<UserDto> dto = new ArrayList<UserDto>();
//		
//		ModelMapper  mapper = new ModelMapper();
//		mapper.map(mapper, dto);
//		
//		if(user != null) {
//			ResponseStructure<List<UserDto>> structure = new ResponseStructure<List<UserDto>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Admin");
//			structure.setData(dto);
//			return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure,HttpStatus.FOUND);
//		}
//		throw new UserListNotFound("Admin list doesn't exist");
//	}
	
	
       
	
}
