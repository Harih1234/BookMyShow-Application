package com.springproject.bookmyshow.exception;

public class ShowListNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public ShowListNotFound(String message) {
	
		this.message = message;
	}
	
	
}
