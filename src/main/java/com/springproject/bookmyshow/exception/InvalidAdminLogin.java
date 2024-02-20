package com.springproject.bookmyshow.exception;

public class InvalidAdminLogin extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public InvalidAdminLogin(String message) {
		super();
		this.message = message;
	}
	
	
}
