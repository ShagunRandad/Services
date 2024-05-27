package com.exam.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.exam.portal.Repository.AppUserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AppUserRepo appUserRepo;

	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    var appUser = appUserRepo.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

	    return new User(appUser.getUsername(), appUser.getPassword(), appUser.getAuthorities());
	  }
}
