package com.exception;

@SuppressWarnings("serial")
public class OrderServiceException extends Exception {

	public OrderServiceException(String str) {
		super(str);
	}
}
