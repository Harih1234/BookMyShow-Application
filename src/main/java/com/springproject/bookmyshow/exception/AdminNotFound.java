package com.springproject.bookmyshow.exception;

public class AdminNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public AdminNotFound(String message) {
		
		this.message = message;
	}
	
	
}
