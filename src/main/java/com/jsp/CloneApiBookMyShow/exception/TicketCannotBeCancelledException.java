package com.jsp.CloneApiBookMyShow.exception;

import lombok.Getter;

@Getter
public class TicketCannotBeCancelledException extends RuntimeException {
	String message;

	public TicketCannotBeCancelledException(String message) {
		super();
		this.message = message;
	}
	
	

}
