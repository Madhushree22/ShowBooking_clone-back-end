package com.jsp.CloneApiBookMyShow.exception;

public class ProductionHouseIdNotFoundException extends RuntimeException {

	String message;

	public ProductionHouseIdNotFoundException(String message) {
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
