package com.springproject.bookmyshow.exception;

public class ShowNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public ShowNotFound(String message) {
		
		this.message = message;
	}
	
	
}
