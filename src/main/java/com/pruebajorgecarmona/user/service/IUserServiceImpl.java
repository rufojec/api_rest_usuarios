package com.pruebajorgecarmona.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebajorgecarmona.user.entitys.User;
import com.pruebajorgecarmona.user.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IValidationService validationService;

	@Override
	public User createUser(User newUser) {
		User user = null;
		Boolean mailIsValid;
		mailIsValid = validationService.emailFormatValidate(newUser.getEmail());
	    if(mailIsValid.equals(false)) {
	    	return user;
	    }
		return userRepository.save(newUser);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
