package com.jsp.CloneApiBookMyShow.exception;

import lombok.Getter;

@Getter
public class ShowIsNotActiveException extends RuntimeException {
	String message;

	public ShowIsNotActiveException(String message) {
		super();
		this.message = message;
	}
	
	

}
