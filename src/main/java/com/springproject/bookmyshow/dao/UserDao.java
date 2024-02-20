package com.springproject.bookmyshow.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.entity.User;
import com.springproject.bookmyshow.repo.UserRepo;
import com.springproject.bookmyshow.util.ResponseStructure;

@Repository
public class UserDao {

	@Autowired
	UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User findUser(int userId) {
		Optional<User> opUser = repo.findById(userId);
		if(opUser.isPresent()) {
			return opUser.get();
		}
	return null;
	}
	
	public User deleteUser(int userId) {
		User user = findUser(userId);
		repo.delete(user);
		return user;
	}
	public User updateUser(int userId, User user) {
		User exUser = findUser(userId);
		if(exUser != null) {
		user.setUserId(userId);
		return repo.save(user);
	}
		return null;
		
 }
	
//	public ResponseEntity<ResponseStructure<User>> assignBookingUsingUserId(int screenId,int userId){
//		User use = repo.findById(userI)
//		Theatre thea = tdao.findTheatre(theatreId);
//		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
//		
//		if(scr!=null) {
//			if(thea != null) {
//				scr.
//				structure.setData(sdao.updateScreen(screenId, scr));
//				structure.setMessage("Theatre Assigned to Admin");
//				structure.setStatus(HttpStatus.OK.value());
//				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
//				
//			}
//			return null;
//		}	
//		return null;
//	}
	
//	public List<User> findAllUser() {
//		List<User> user = repo.findAll();
//		return user;
//	}
	
}