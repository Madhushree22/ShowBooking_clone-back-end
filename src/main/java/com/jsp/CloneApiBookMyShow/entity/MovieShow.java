package com.jsp.CloneApiBookMyShow.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneApiBookMyShow.enums.ShowStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@DateTimeFormat(style = "HH:MM")
	private LocalTime movieDuration;
	private String movieDescription;
	private String movieLanguage;
	
	//screen attributes that shld be displayed along with show 
	private long screenId;
	private String screenName;
	private double classicSeatPrice;
	private double platinumSeatPrice;
	private double goldSeatPrice;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
   private Theatre theatre;
	

	
	
	

}
