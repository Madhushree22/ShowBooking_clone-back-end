package com.jsp.CloneApiBookMyShow.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
