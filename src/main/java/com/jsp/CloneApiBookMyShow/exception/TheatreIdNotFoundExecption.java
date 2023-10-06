package com.jsp.CloneApiBookMyShow.exception;

public class TheatreIdNotFoundExecption extends RuntimeException {
	String message;

	public TheatreIdNotFoundExecption(String message) {
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
