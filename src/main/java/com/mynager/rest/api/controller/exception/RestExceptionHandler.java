package com.mynager.rest.api.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mynager.rest.api.model.ErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, NotFoundException.class })
	public ResponseEntity<Object> internalServerException(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(
				ex, ErrorDetails.builder()
				.addDetails("Internal Server Error.")
				.addError(ex.getMessage())
				.addStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				.addHttpMethod(getHttpMethod(request))
				.addPath(getPath(request))
				.build(),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler({ AuthorizationException.class })
	public ResponseEntity<Object> accessDeniedException(AuthorizationException ex, WebRequest request) {
		return handleExceptionInternal(
				ex, ErrorDetails.builder()
				.addDetails("Access Denied.")
				.addError(ex.getMessage())
				.addStatus(HttpStatus.FORBIDDEN)
				.addHttpMethod(getHttpMethod(request))
				.addPath(getPath(request))
				.build(),
				new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
	private String getPath(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getRequestURI();
	}

	private String getHttpMethod(WebRequest request) {		
		return ((ServletWebRequest) request).getRequest().getMethod();
	}
}
