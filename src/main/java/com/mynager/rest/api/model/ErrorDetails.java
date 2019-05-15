package com.mynager.rest.api.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer statusCode;
	private String statusMessage;
	private String httpMethod;
	private String error;
	private String details;

	// getters e setters

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
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

	// static method builder
	public static Builder builder() {
		return new Builder();
	}

	// static class builder
	public static class Builder {
		private ErrorDetails errorDt;
		
		// constructor builder
		Builder() {
			this.errorDt = new ErrorDetails();
		}

		// error status
		public Builder addStatus(HttpStatus status) {
			this.errorDt.statusCode = status.value();
			this.errorDt.statusMessage = status.getReasonPhrase();
			return this;
		}

		// http method
		public Builder addHttpMethod(String method) {
			this.errorDt.httpMethod = method;
			return this;
		}

		// error
		public Builder addError(String error) {
			this.errorDt.error = error;
			return this;
		}

		// details
		public Builder addDetails(String details) {
			this.errorDt.details = details;
			return this;
		}
		
		public ErrorDetails build() {
			return this.errorDt;
		}
	}
}
