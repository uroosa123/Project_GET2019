package com.iris.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iris.models.User;

@Component
public class GenerateValidator implements Validator{

	
	public boolean supports(Class<?> obj) {
		return User.class.isAssignableFrom(obj);
	}

	
	public void validate(Object target, Errors errors) {
		User uObj=(User)target;
		String gender=uObj.getGender();
		
		if((gender.equals("Male")) || (gender.equals("Female"))){
			System.out.println("Correct");
		}
		else {
			errors.reject("gender","Only Male and Female allowed for Gender");
		}
		
		
	}

	
}