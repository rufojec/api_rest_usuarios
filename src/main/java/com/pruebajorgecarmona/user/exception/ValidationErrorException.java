package com.pruebajorgecarmona.user.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationErrorException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValidationErrorException(String message) {
		super(message);
	}
}
