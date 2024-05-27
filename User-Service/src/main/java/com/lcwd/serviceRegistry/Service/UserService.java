package com.lcwd.serviceRegistry.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.serviceRegistry.Entity.User;

@Service
public interface UserService {

	User saveUser(User user);
	
	void deleteUserById(String userId);
	
	List<User> getAllUsers();
	
	User updateUserById(User user);
	
	User getUserById(String id);
	
	
	
}
