package com.hexaware.CMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	ResourceNotFoundException(String resourceName,String fieldName,String fieldValue)
	{
		super(String.format("%s Resourse not found with field %s and valye %s",fieldName,fieldName,fieldValue));
	}
	
}
