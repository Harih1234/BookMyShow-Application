package com.springproject.bookmyshow.exception;

public class UserNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public UserNotFound(String message) {
		
		this.message = message;
	}
	
	
}
