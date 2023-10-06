package com.jsp.CloneApiBookMyShow.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneApiBookMyShow.enums.Genre;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	private String movieName;
	

	//genre(fr enum)
	private Genre genre1;
	private Genre genre2;
	private Genre genre3;
	
@DateTimeFormat(style = "HH:MM")
	private LocalTime movieDuration;
	private String movieDescription;
	private String language;
	@ManyToOne
	@JsonIgnore
	@JoinColumn
	private ProductionHouse productionHouse;
	

}
