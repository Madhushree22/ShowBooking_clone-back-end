package com.jsp.CloneApiBookMyShow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long customerId;
	private String customerName;
	private long customerPhone;
	private String customerEmail;
	private String customerPassword;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Ticket> ticket;
	
	

}
