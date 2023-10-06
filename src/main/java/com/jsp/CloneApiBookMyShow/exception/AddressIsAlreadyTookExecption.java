package com.jsp.CloneApiBookMyShow.exception;

public class AddressIsAlreadyTookExecption extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AddressIsAlreadyTookExecption(String message) {
		super();
		this.message = message;
	}
	
	
}
