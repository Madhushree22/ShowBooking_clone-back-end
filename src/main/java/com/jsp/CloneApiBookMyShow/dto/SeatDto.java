package com.jsp.CloneApiBookMyShow.dto;




import com.jsp.CloneApiBookMyShow.enums.ScreenType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {

	
	private long seatId;
	
	//enum seat type
	private ScreenType screenType;
}
