package com.jsp.CloneApiBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneApiBookMyShow.enums.ShowStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieShowDto {
	
	
	private long showId;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	
	//show status (fr enum)
	private ShowStatus showStatus;
	
	private String showLocation;
	
	//movie attributes that shld be displayed along with show 
	private long movieId;
	private String movieName;
	
	
	
	private String genre;
	private LocalDateTime movieDuration;
	private String movieDescription;
	private String movieLanguage;
	
	//screen attributes that shld be displayed along with show 
	private long screenId;
	private String screenName;
	private double classicSeatPrice;
	private double platinumSeatPrice;
	private double goldSeatPrice;
	

}
