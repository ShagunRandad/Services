package com.exam.portal.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.Exception.UserDefineException;
import com.exam.portal.Repository.RoleRepository;
import com.exam.portal.Repository.UserRepository;
import com.exam.portal.entity.User;
import com.exam.portal.entity.UserRole;
import com.exam.portal.payload.UserDto;


@Service
public class UserServiceImpl implements com.exam.portal.service.UserService{


	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private RoleRepository roleRepository;


	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public User createUser(UserDto userDto) {
		User local = this.userRepository.findByUserName(userDto.getUserName());
		if (local != null) {
			throw new UserDefineException("This User Already present inside database");
		} else {
			
			 local=this.modelMapper.map(userDto, User.class);
			
			Set<UserRole> userRole = new HashSet<>();
			com.exam.portal.entity.Role role = new com.exam.portal.entity.Role();
			role.setRoleId(1);
			role.setRoleName("NORMAL USER");
			UserRole userRoleModal = new UserRole();
			userRoleModal.setRole(role);
			userRoleModal.setUser(local);
			userRole.add(userRoleModal);
			
			for (UserRole role1 : userRole) {
				roleRepository.save(role1.getRole());
			}
			//user.getUserRole().addAll(userRoles);
			local.setUserRole(userRole);
			local = this.userRepository.save(local);
		}
		return local;
	}


	@Override
	public List<UserDto> getUsersList() {
		List<User> userList= this.userRepository.findAll();
		return userList.stream().map(s-> this.modelMapper.map(s,UserDto.class)).toList();
	}


	@Override
	public UserDto getUserById(int id) {
	    User user = this.userRepository.findById(id)
	            .orElseThrow(() -> new UserDefineException("No user found with this id"));

	    return this.modelMapper.map(user, UserDto.class);
	}


	@Override
	public UserDto updateUserById(int id,UserDto userDto) {
		this.userRepository.findById(id)
				.orElseThrow(()-> new UserDefineException("No user Found by this id"));
	 this.userRepository.save(this.modelMapper.map(userDto, User.class));
	 return userDto;
	}


	@Override
	public Boolean deleteUserById(int id) {
		this.userRepository.findById(id)
		.orElseThrow(()-> new UserDefineException("No user Found by this id"));
		this.userRepository.deleteById(id);
		return true;
	}

}
