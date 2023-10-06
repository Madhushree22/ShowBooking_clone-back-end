package com.jsp.CloneApiBookMyShow.exception;

public class OwnerIdNotFoundExecption extends RuntimeException {
	private String message;

	public OwnerIdNotFoundExecption(String message) {
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
