package com.exam.portal.entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Authority  implements GrantedAuthority {
	
	private String authority;


	@Override
	public String getAuthority() {
		return null;
	}

}
