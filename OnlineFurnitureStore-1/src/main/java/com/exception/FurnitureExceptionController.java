package com.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.exception.FurnitureServiceException;

@RestControllerAdvice
public class FurnitureExceptionController {

	
	@ExceptionHandler(FurnitureServiceException.class)
	public ResponseEntity<String> handleFurnitureServiceException(FurnitureServiceException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	


}
