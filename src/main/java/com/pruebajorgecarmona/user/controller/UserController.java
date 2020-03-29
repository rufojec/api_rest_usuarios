package com.pruebajorgecarmona.user.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebajorgecarmona.user.entitys.User;
import com.pruebajorgecarmona.user.exception.ResourceNotFoundException;
import com.pruebajorgecarmona.user.exception.ValidationErrorException;
import com.pruebajorgecarmona.user.service.IUserService;
import com.pruebajorgecarmona.user.service.IValidationService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IValidationService validationService;
	
	@PostMapping("/user")
    public ResponseEntity < User > createUser(@Valid @RequestBody User user) throws ValidationErrorException {
		Boolean mailValid = false;
		Boolean passValid = false;
		mailValid = validationService.emailFormatValidate(user.getEmail()); 
		passValid = validationService.passwordFormatValidate(user.getPassword());
		
		if(false == mailValid) {
			throw new ValidationErrorException("email does not comply with the required format aaaaa@domain.com :: " + user.getEmail());
		}
		
		if(false == passValid) {
			throw new ValidationErrorException("The password must be between 4 and 8 characters, at least one digit, at least one lowercase, at least one uppercase :: " + user.getPassword());
		}
		
		User newUser = userService.createUser(user);
        return ResponseEntity.ok().body(newUser);
    }
	
	@PutMapping("/users/{id}")
    public ResponseEntity < User > updateEmployee(@PathVariable(value = "id") Long id,
        @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setPhones(userDetails.getPhones());
        user.setModified(new Date());
        User updatedUser = userService.createUser(user);
        return ResponseEntity.ok(updatedUser);
    }
	
	@GetMapping("/user/{id}")
    public ResponseEntity < User > getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }
	
	@GetMapping("/users")
    public List < User > getAllUsers() {
        return userService.findAllUser();
    }
	
	
}
