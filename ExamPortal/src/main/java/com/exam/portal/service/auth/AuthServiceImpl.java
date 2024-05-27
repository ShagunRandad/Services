package com.exam.portal.service.auth;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.portal.Repository.AppUserRepo;
import com.exam.portal.entity.AppUser;
import com.exam.portal.util.JwtUtils;
@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AppUserRepo appUserRepo;
	  

	  @Override
	  public String login(String username, String password) {
	    var authToken = new UsernamePasswordAuthenticationToken(username, password);

	    var authenticate = authenticationManager.authenticate(authToken);

	    // Generate Token
	    return JwtUtils.generateToken(((UserDetails)(authenticate.getPrincipal())).getUsername());
	  }

	  @Override
	  public String signUp(String name, String username, String password) {
	    // Check whether user already exists or not
	    if(appUserRepo.existsByUsername(username)){
	      throw new RuntimeException("User already exists");
	    }

	    // Encode password
	    var encodedPassword = passwordEncoder.encode(password);

	    // Authorities
	    var authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

	    // Create App user
	    var appUser = AppUser.builder().
	    		id(UUID.randomUUID().toString())
	        .name(name)
	        .username(username)
	        .password(encodedPassword)
	        .authorities(authorities)
	        .build();


	    // Save user
	    appUserRepo.save(appUser);

	    // Generate Token
	    return JwtUtils.generateToken(username);
	  }

	  @Override
	  public String verifyToken(String token) {
	    var usernameOptional = JwtUtils.getUsernameFromToken(token);

	    if(usernameOptional.isPresent()){
	      return usernameOptional.get();
	    }

	    throw new RuntimeException("Token invalid");
	  }
	
}
