package com.jsp.CloneApiBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.Customer;
import com.jsp.CloneApiBookMyShow.repository.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	
	private CustomerRepo repo;
	
	public Customer saveCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	
	public Customer updateCustomer(long customerId,Customer customer)
	{
		 Optional<Customer> optional=repo.findById(customerId);
		 
		 if(optional.isPresent())
		 {
			 customer.setCustomerId(customerId);
			 repo.save(customer);
			 return customer;
		 }
		 
		 return null;
	}
	
	public Customer deleteCustomerById(long customerId)
	{
		Optional<Customer> optional=repo.findById(customerId);
		 
		 if(optional.isPresent())
		 {
			 repo.deleteById(customerId);
			 return optional.get();
		 }
		 return null;
	}
	
	public Customer findCustomerById(long customerId)
	{
		Optional<Customer> optional=repo.findById(customerId);
		 
		 if(optional.isPresent())
		 {
			 return optional.get();
		
	}
		 return null;
	}
	

}
