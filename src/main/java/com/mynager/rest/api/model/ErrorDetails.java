package com.mynager.rest.api.model;

import java.io.Serializable;

/*
 * post details error 
 */

public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String statusMessage;
	private String httpMethod;
	private String error;
	private String details;

	// getters e setters

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
