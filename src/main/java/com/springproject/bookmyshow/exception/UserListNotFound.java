package com.springproject.bookmyshow.exception;

public class UserListNotFound  extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public UserListNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
