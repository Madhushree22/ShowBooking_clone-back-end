package com.jsp.CloneApiBookMyShow.exception;

public class ScreenAlreadyAllotedException extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ScreenAlreadyAllotedException(String message) {
		super();
		this.message = message;
	}
	

}
