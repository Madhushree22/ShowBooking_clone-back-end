package com.jsp.CloneApiBookMyShow.exception;

public class ScreenIdNotFoundException extends RuntimeException {
	String message;

	public ScreenIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
