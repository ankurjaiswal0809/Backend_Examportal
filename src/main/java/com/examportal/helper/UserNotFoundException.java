package com.examportal.helper;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String mg){		
		super(mg);
	}

}
