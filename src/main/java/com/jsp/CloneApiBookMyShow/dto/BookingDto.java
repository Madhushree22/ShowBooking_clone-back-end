package com.jsp.CloneApiBookMyShow.dto;

import java.time.LocalDateTime;


import com.jsp.CloneApiBookMyShow.enums.BookingStatus;
import com.jsp.CloneApiBookMyShow.enums.SeatType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingDto {
	
	private long bookingId;
	
	private LocalDateTime bookingFromTime;
	private LocalDateTime bookingTillTime;
	
	private long seatId;
	
	//seat type
	private SeatType seatType;
	
	//booking status
	private BookingStatus bookingstatus;
	
	private double seatPrice;
	

}
