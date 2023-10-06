package com.jsp.CloneApiBookMyShow.exception;

import lombok.Getter;

@Getter
public class TicketIdNotFoundException extends RuntimeException {
	String message;

	public TicketIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
