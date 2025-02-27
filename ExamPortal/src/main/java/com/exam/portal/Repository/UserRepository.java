package com.exam.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.portal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
 
	public User findByUserName(String userName);
}
