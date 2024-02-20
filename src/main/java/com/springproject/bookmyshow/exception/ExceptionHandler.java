package com.springproject.bookmyshow.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.springproject.bookmyshow.util.ResponseStructure;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;



@RestControllerAdvice
public class ExceptionHandler  extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminNotFoundException(AdminNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage("Admin does not exist");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AdminListNotFound(AdminListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage("Admin list not found in the db");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingNotFoundException(BookingNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage("Booking does not exist");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingListNotFoundException(BookingListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage("Booking List does not exist");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> invalidAdminLoginException(InvalidAdminLogin ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Invalid Admin ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> movieNotFoundException(MovieNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Movie Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> movieListNotFoundException(MovieListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Movie List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> screenNotFoundException(ScreenNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Movie List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> screenListNotFoundException(ScreenListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Movie List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> showNotFoundException(ShowNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Show Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> showListNotFoundException(ShowListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Show List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreNotFoundException(TheatreNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Theatre Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreListNotFoundException(TheatreListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" Theatre List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFoundException(UserNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" User Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userListNotFoundException(UserListNotFound ex){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setData(ex.getMessage());
	structure.setMessage(" User List Doesn't Exist ");
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
		ResponseStructure<Object> structure = new ResponseStructure<>();
		Map<String , String> hashmap = new HashMap<>();
		
		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessage("Add Proper Details ");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		
		return new ResponseEntity<Object> (structure,HttpStatus.BAD_REQUEST);

	}
	
}

