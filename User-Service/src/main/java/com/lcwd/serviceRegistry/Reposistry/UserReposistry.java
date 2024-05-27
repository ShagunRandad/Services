package com.lcwd.serviceRegistry.Reposistry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.serviceRegistry.Entity.User;
@Repository
public interface UserReposistry extends CrudRepository<User, String> {

}
