package com.springproject.bookmyshow.exception;

public class ScreenListNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public ScreenListNotFound(String message) {
		
		this.message = message;
	}
	
}
