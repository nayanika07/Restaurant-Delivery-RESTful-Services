package com.nka.menuitem.controller;




import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nka.menuitem.exception.MenuitemException;
import com.nka.menuitem.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler({MenuitemException.class})
	public ResponseEntity<CustomErrorResponse> handleMenuitemException(MenuitemException ex){
		
		CustomErrorResponse response=new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid Menuitem Id Provided");
		
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
		
		
	
		
		
	}
}
