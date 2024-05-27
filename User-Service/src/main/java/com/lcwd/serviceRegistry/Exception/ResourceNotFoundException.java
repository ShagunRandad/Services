package com.lcwd.serviceRegistry.Exception;


public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource Not Found Exception");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
}
