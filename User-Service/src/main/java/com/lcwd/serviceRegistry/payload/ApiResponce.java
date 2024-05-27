package com.lcwd.serviceRegistry.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiResponce {
	private String message;
	private boolean success;
	private HttpStatus status;
	

}
