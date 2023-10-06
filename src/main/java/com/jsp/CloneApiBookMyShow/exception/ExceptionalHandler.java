package com.jsp.CloneApiBookMyShow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionalHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> OwnerIdNotFoundExecption(OwnerIdNotFoundExecption ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for owner");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ProductionHouseIdNotFoundException(ProductionHouseIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for productionhouse");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AddressNotFoundException(AddressNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for address");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheatreIdNotFoundExecption(TheatreIdNotFoundExecption ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for theatre");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AddressIsAlreadyTookExecption(AddressIsAlreadyTookExecption ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("address is alreay taken..");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> CustomerIdNotFoundException(CustomerIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("customerid is not present");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ScreenIdNotFoundException(ScreenIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for screen");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> MovieIdNotFoundException(MovieIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for movie");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ScreenAlreadyAllotedException(ScreenAlreadyAllotedException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("screen may be alloted to other shows");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ShowIdNotFoundException(ShowIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for show");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ShowIsNotActiveException(ShowIsNotActiveException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("show active is not active");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> SeatIdNotFoundException(SeatIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for the seat");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketIdNotFoundException(TicketIdNotFoundException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found for the ticket");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketCannotBeCancelledException(TicketCannotBeCancelledException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("sorry show is ongoing sp failed to cancel the ticket");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketAlreadyCancelledException(TicketAlreadyCancelledException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("the ticket is already cancelled");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketAlreadyExpiredException(TicketAlreadyExpiredException ex)

	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("the ticket is already expired");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	

}
