package br.com.futurodev.pizzaria.api.error;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class apiExceptionError extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> entidadeNotFoundException(EntityNotFoundException e, WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), status, request);
	}

}
