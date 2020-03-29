package com.pruebajorgecarmona.user.service;

import java.util.List;
import java.util.Optional;

import com.pruebajorgecarmona.user.entitys.User;

public interface IUserService  {
	public User createUser(User user);
	public Optional<User>  findById(Long id);
	public List<User> findAllUser();
	
}
