package com.springproject.bookmyshow.exception;

public class ScreenNotFound  extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public ScreenNotFound(String message) {
		
		this.message = message;
	}
	
	

}
