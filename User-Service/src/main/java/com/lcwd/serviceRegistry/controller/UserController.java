package com.lcwd.serviceRegistry.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.serviceRegistry.Entity.User;
import com.lcwd.serviceRegistry.ServiceImpl.UserServiceImpl;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userServiceImpl.getAllUsers();
	}
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		return userServiceImpl.saveUser(user);
	}
	
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") String userId) {
		return userServiceImpl.getUserById(userId);	
	}
	
	
	

}
