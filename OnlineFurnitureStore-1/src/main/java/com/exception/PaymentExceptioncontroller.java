package com.exception;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.exception.PaymentException;

@RestControllerAdvice
public class PaymentExceptioncontroller {

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<String> handlePaymentServiceException(PaymentException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}