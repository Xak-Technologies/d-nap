package com.xakt.dnap.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xakt.dnap.entity.ResponseMessage;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
//	NOT FOUND EXCEPRION
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseMessage> notFoundException(
			NotFoundException exception, WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage(
				HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	}
	
	
//	BLANK FIELD EXCEPTION
	@ExceptionHandler(BlankFieldException.class)
	public ResponseEntity<ResponseMessage> blankFieldException(
			 BlankFieldException exception, WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage(
				HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
	}
	
//	SUCCESS MESSAGE EXCEPTION
	@ExceptionHandler(SuccessMessageException.class)
	public ResponseEntity<ResponseMessage> successMessageException(
			 SuccessMessageException exception, WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage(
				HttpStatus.OK, exception.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}
	
	
//	ALREADY EXISTS EXCEPTION
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ResponseMessage> alreadyExistsException(
			 AlreadyExistsException exception, WebRequest request) {
		ResponseMessage responseMessage = new ResponseMessage(
				HttpStatus.CONFLICT, exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(responseMessage);
	}
}


