package com.jsp.CloneApiBookMyShow.dto;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jsp.CloneApiBookMyShow.enums.ScreenAvailabilty;
import com.jsp.CloneApiBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApiBookMyShow.enums.ScreenType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenDto {
	
	private long screenId;
	private String screenName;
	//enum
	//screentype
	private ScreenType screentype;
	//screenavailability
	private ScreenAvailabilty ScreenAvailability;
	//screenstatus
	private ScreenStatus screenstatus;
	
	
	
	private int noOfClassicSeat;
	private int noOfPlatinumSeat;
	private int noOfGoldSeat;
	

}
