package com.springproject.bookmyshow.exception;

public class AdminListNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
		
		
	}

	public AdminListNotFound(String message) {
	
		this.message = message;
	}
}
