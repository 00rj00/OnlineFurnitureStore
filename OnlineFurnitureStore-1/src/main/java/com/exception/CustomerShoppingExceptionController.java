package com.exception;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.exception.CustomerShoppingException;

@RestControllerAdvice
public class CustomerShoppingExceptionController {

	@ExceptionHandler(CustomerShoppingException.class)
	public ResponseEntity<String> handleCustonerShoppingServiceException(CustomerShoppingException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
