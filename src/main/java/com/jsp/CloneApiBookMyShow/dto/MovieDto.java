package com.jsp.CloneApiBookMyShow.dto;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.jsp.CloneApiBookMyShow.enums.Genre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
	
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

}
