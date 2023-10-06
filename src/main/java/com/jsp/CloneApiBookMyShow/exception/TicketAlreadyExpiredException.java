package com.jsp.CloneApiBookMyShow.exception;

import lombok.Getter;

@Getter
public class TicketAlreadyExpiredException extends RuntimeException {

	public TicketAlreadyExpiredException(String message) {
		super();
		this.message = message;
	}

	String message;
	
}
