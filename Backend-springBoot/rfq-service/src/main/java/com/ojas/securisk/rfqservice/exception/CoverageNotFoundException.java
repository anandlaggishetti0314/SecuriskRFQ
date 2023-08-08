package com.ojas.securisk.rfqservice.exception;

import java.util.List;
import java.util.Map;

import org.springframework.graphql.execution.ErrorType;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class CoverageNotFoundException extends RuntimeException implements GraphQLError {

	private ErrorType errorType;
	private String message;
	private Map<String, Object> extension;

	public CoverageNotFoundException(ErrorType errorType, String message, Map<String, Object> extension) {
		this.errorType = errorType;
		this.message = message;
		this.extension = extension;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return errorType;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getExtension() {
		return extension;
	}
	
	

}
