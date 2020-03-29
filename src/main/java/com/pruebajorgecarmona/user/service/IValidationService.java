package com.pruebajorgecarmona.user.service;

public interface IValidationService {
	public Boolean emailFormatValidate(String email);
	
	public Boolean passwordFormatValidate(String password);
}
