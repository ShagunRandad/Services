package com.lcwd.serviceRegistry.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.serviceRegistry.payload.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> handeledResorceNotFoundException(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponce responce=ApiResponce.builder().message(ex.getMessage()).success(true).status(HttpStatus.BAD_REQUEST).build();
	return new ResponseEntity<>(responce,HttpStatus.BAD_REQUEST);
	}
	
}
