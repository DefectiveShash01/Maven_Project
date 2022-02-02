package com.athenahealth.demo;

public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	static String s= "4000: ";
	public RecordNotFoundException(String message) {
		super(s+message);
	}
	public RecordNotFoundException(Throwable cause) {
		super(cause);
	}

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
