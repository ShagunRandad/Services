package com.lcwd.hotelService.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(){
		super("Something went wrong");
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}
}
