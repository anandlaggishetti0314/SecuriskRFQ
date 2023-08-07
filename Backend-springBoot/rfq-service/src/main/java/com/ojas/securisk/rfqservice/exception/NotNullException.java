package com.ojas.securisk.rfqservice.exception;

public class NotNullException extends RuntimeException{
	private String message;
	public NotNullException(String message) {
		super(message);
		this.message = message;
	}
}
