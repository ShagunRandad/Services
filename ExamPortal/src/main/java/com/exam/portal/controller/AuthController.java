package com.exam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.service.auth.AuthService;
import com.exam.portal.util.ApiResponse;

import jakarta.security.auth.message.AuthStatus;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping(value="/api/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	  @PostMapping("/login")
	  public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
	    var jwtToken = authService.login(authRequestDto.username(), authRequestDto.password());
	    
	    var authResponseDto = new AuthResponseDto(jwtToken);

	    return ResponseEntity
	        .status(HttpStatus.OK)
	        .body(authResponseDto);
	  }

	  @PostMapping("/sign-up")
	  public ResponseEntity<ApiResponse<AuthResponseDto>> signUp(@RequestBody AuthRequestDto authRequestDto) {
        	log.info("Eneterd into Sign Up Code");
       	System.out.println("Entered");
	    try {
	      var jwtToken = authService.signUp(authRequestDto.name(), authRequestDto.username(), authRequestDto.password());

	      var authResponseDto = new AuthResponseDto(jwtToken);

			return ResponseEntity.ok(ApiResponse.success("Token Created Succesfully",authResponseDto ));
		} catch (Exception e) {
	      var authResponseDto = new AuthResponseDto(null);
	      

	      return ResponseEntity
	          .status(HttpStatus.CONFLICT)
	          .body(ApiResponse.error("Something went Wrong"));
	    }
	  }

	  @PostMapping("/verify-token")
	  public ResponseEntity<String> verifyToken(@RequestBody String token) {
	    try {
	      var username = authService.verifyToken(token.substring(7));

	      return ResponseEntity
	          .status(HttpStatus.OK)
	          .body(username);
	    } catch (Exception e) {
	      return ResponseEntity
	          .status(HttpStatus.UNAUTHORIZED)
	          .build();
	    }
	  }

}
