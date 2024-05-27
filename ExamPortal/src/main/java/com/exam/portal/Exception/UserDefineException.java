package com.exam.portal.Exception;

public class UserDefineException extends RuntimeException  {
	
	public UserDefineException(){
		super(" Something went wrong please contact admin");
	}
	
	public UserDefineException(String message){
	   super(message);
	}

}
