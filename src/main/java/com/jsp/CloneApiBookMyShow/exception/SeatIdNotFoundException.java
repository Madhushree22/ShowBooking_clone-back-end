package com.jsp.CloneApiBookMyShow.exception;

import lombok.Getter;

@Getter
public class SeatIdNotFoundException extends RuntimeException {
	
	String message;

	public SeatIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
