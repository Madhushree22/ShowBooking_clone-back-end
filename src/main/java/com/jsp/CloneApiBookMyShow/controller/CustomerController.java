package com.jsp.CloneApiBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneApiBookMyShow.entity.Customer;
import com.jsp.CloneApiBookMyShow.dto.CustomerDto;
import com.jsp.CloneApiBookMyShow.service.CustomerService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@RequestBody Customer customer)
	{
		return service.saveCustomer(customer);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerById(@RequestParam long customerId)
	{
		return service.findCustomerById(customerId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@RequestParam long customerId,@RequestBody Customer customer)
	{
		return service.updateCustomer(customerId,customer);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomerById(@RequestParam long customerId)
	{
		return service.deleteCustomerById(customerId);
	}
	
	

}
