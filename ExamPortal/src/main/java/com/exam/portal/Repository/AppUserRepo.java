package com.exam.portal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
	  boolean existsByUsername(String username);

	  Optional<AppUser> findByUsername(String username);
	}
	