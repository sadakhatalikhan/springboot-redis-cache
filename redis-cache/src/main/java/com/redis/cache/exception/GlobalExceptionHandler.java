package com.redis.cache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.redis.cache.response.Response;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ProductExistsException.class)
	public ResponseEntity<Response> handleProductExistsException(ProductExistsException ex) {
		return ResponseEntity.badRequest().body(Response.builder().code(ex.getCode()).message(ex.getMessage()).build());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotExistsException.class)
	public ResponseEntity<Response> handleProductNotExistsException(ProductNotExistsException ex) {
		return ResponseEntity.badRequest().body(Response.builder().code(ex.getCode()).message(ex.getMessage()).build());
	}
}
