package com.pruebajorgecarmona.user.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pruebajorgecarmona.user.exception.ResourceNotFoundException;

@Service
public class IValidationServiceImpl implements IValidationService {

	@Override
	public Boolean emailFormatValidate(String email) {
		Boolean mailIsValid = false;
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			mailIsValid = true;
		}
		return mailIsValid;

	}

	@Override
	public Boolean passwordFormatValidate(String pass) {
		Boolean passIsValid = false;
		Pattern pattern = Pattern.compile(
				"(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,8}");

		Matcher mather = pattern.matcher(pass);

		if (mather.find() == true) {
			passIsValid = true;
		}
		return passIsValid;
	}

}
