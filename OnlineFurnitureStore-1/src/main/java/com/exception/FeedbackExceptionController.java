package com.exception;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.exception.CustomerFeedbackException;

@RestControllerAdvice
public class FeedbackExceptionController {

	@ExceptionHandler(CustomerFeedbackException.class)
	public ResponseEntity<String> handleFeedbackServiceException(CustomerFeedbackException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.ACCEPTED);
	}
}