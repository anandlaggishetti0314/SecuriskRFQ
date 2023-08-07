package com.ojas.securisk.rfqservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.ojas.securisk.rfqservice.entity.ProductCategeoryData;

import io.netty.handler.codec.http.HttpHeaders;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotNullException.class)
	public ResponseEntity<Map<String, Object>> NotNullException(NotNullException exception) {
		ProductCategeoryData payload = ProductCategeoryData.builder().build();
		Map<String, Object> response = new HashMap<>();
		response.put("productCategeory", payload.getProductCategeory());
		response.put("productName", payload.getProductName());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
}