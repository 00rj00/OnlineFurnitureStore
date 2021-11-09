
package com.exception;


import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.exception.ShoppingCartException;
@RestControllerAdvice
public class ShoppingCartExceptionController {

	@ExceptionHandler(ShoppingCartException.class)
	public ResponseEntity<String> handleShoppingCartServiceException(ShoppingCartException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}