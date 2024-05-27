package com.exam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.User;
import com.exam.portal.payload.UserDto;
import com.exam.portal.service.UserService;

@RestController
@RequestMapping(value="/v1/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers(){
		return this.userService.getUsersList();
	
	}
	
	@GetMapping("/getUserById/{id}")
	public UserDto getAllUsers(@PathVariable int id){
		return this.userService.getUserById(id);
	}

}
