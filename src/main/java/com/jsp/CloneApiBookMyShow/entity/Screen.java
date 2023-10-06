package com.jsp.CloneApiBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jsp.CloneApiBookMyShow.enums.ScreenAvailabilty;
import com.jsp.CloneApiBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApiBookMyShow.enums.ScreenType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screenId;
	private String screenName;
	
	//enum
	//screentype
	private ScreenType screentype;
	
	//screenavailability
	private ScreenAvailabilty ScreenAvailability;
	
	//screenstatus
	private ScreenStatus screenstatus;
	
	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
	private List<Seat> seats;
	
	private int noOfClassicSeat;
	private int noOfPlatinumSeat;
	private int noOfGoldSeat;
	
	@ManyToOne
	@JoinColumn
	private Theatre theatre;
	

}
