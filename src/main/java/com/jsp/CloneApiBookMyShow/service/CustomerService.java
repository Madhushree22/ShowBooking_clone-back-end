package com.jsp.CloneApiBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.CustomerDao;

import com.jsp.CloneApiBookMyShow.dto.CustomerDto;

import com.jsp.CloneApiBookMyShow.entity.Customer;
import com.jsp.CloneApiBookMyShow.exception.CustomerIdNotFoundException;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {
		Customer dbcustomer=dao.saveCustomer(customer);
		CustomerDto dto=this.modelMapper.map(dbcustomer, CustomerDto.class);
		ResponseStructure<CustomerDto> st=new ResponseStructure<CustomerDto>();
		st.setMessage("the customer is saved successfully");
		st.setStatus(HttpStatus.CREATED.value());
		st.setData(dto);
		
		return new ResponseEntity<ResponseStructure<CustomerDto>>(st,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerById(long customerId) {
		Customer dbCustomer=dao.findCustomerById(customerId);
		if(dbCustomer!=null)
		{
			ResponseStructure<CustomerDto> st=new ResponseStructure<CustomerDto>();
			st.setMessage("the customer is fetched successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(st,HttpStatus.FOUND);
		}
		
		throw new CustomerIdNotFoundException("sorry the couldnt fetch the data");
		
		
		
	}
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(long customerId, Customer customer) {
		Customer dbCustomer=dao.updateCustomer(customerId, customer);
		if(dbCustomer!=null) {
			CustomerDto dto=this.modelMapper.map(dbCustomer, CustomerDto.class);
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer Updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.OK);
		}else {
			throw new CustomerIdNotFoundException("sorry failed to update customer");
		}
	}
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomerById(long customerId) {

		Customer dbCustomer=dao.deleteCustomerById(customerId);
		if(dbCustomer!=null) {
			ResponseStructure<CustomerDto> st=new ResponseStructure<CustomerDto>();
			st.setMessage("Customer deleted successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(st,HttpStatus.FOUND);
		}else {
			throw new CustomerIdNotFoundException("sorry failed to Delete customer");
		}
	}
	
	

}
