package com.jsp.CloneApiBookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneApiBookMyShow.enums.ScreenType;
import com.jsp.CloneApiBookMyShow.enums.SeatType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatId;
	
	//enum seat type
	private SeatType seatType;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Screen screen;

}
