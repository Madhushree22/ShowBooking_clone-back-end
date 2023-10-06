package com.jsp.CloneApiBookMyShow.exception;

public class MovieIdNotFoundException extends RuntimeException {
	String message;

	public MovieIdNotFoundException(String message) {
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
