package com.jsp.CloneApiBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long theatreId;
	private String theatreName;
	
	
	@OneToOne
	@JoinColumn
	private Address address;
	
	@OneToMany(mappedBy = "theatre",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Screen> screen;
	
	@ManyToOne
	@JoinColumn
	private Owner owner;
	
	@OneToMany(mappedBy = "theatre")
	
	private List<MovieShow> movieshows;

}
