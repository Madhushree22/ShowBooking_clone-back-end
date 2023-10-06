package com.jsp.CloneApiBookMyShow.exception;

public class ShowIdNotFoundException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ShowIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
