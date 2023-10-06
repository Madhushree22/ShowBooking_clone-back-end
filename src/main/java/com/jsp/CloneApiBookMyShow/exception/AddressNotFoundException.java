package com.jsp.CloneApiBookMyShow.exception;

public class AddressNotFoundException extends RuntimeException {
	
	String message;

	public AddressNotFoundException(String message) {
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
