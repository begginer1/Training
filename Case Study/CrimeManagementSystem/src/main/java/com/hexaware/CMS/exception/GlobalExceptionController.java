package com.hexaware.CMS.exception;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ErrorDetails>	handleAlreadyExistException(AlreadyExistException obj,WebRequest req)
	{
		ErrorDetails error=new ErrorDetails(LocalDate.now(),obj.getMessage(),req.getDescription(false),"AlreadyExistException");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotExistException.class)
	public ResponseEntity<ErrorDetails> handleNotExistException(NotExistException obj,WebRequest req)
	{
		ErrorDetails error=new ErrorDetails(LocalDate.now(),obj.getMessage(),req.getDescription(false),"Not Exist Exception");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(BadRequestException obj,
                                                               WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), obj.getMessage(),
                webRequest.getDescription(false),obj.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                               WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), exception.getMessage(),
                webRequest.getDescription(false),exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
