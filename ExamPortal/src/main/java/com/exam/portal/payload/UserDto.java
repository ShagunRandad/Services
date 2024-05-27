package com.exam.portal.payload;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserDto {
	  private String userName;
	  private String password;
	  private String firstName;
	  private String lastName;
	  private String email;
	  private String phone;
	  private boolean enable=true;
	  private String profile;
	  
	 
	  private Set<RoleDto> userRole=new HashSet<>();
	  

}
