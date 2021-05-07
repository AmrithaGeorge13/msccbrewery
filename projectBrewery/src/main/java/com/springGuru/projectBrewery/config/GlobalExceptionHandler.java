package com.springGuru.projectBrewery.config;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<List> exceptionHandler(ConstraintViolationException e1){
		
		List<String> errors=new ArrayList<>(e1.getConstraintViolations().size());
		e1.getConstraintViolations().forEach(violations->{
			errors.add(violations.getPropertyPath()+":"+violations.getMessage());
		});
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
