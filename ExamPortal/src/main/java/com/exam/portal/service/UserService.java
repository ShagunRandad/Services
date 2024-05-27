package com.exam.portal.service;

import java.util.List;

import com.exam.portal.entity.User;
import com.exam.portal.payload.UserDto;

public interface UserService {
	
	public User createUser(UserDto userDto);
	
	public List<UserDto> getUsersList();
	
	public UserDto getUserById(int id);
	
	public UserDto updateUserById(int id,UserDto userDto);
	
	public Boolean deleteUserById(int id);

}
