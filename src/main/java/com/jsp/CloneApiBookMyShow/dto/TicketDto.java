package com.jsp.CloneApiBookMyShow.dto;

import com.jsp.CloneApiBookMyShow.enums.TicketStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto {
	
	private long ticketId;
	private double totalPrice;
	//ticket status
	private TicketStatus ticketStatus;

}
