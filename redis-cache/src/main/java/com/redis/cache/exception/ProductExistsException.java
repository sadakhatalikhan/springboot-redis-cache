package com.redis.cache.exception;

public class ProductExistsException extends RuntimeException {

	private static final long serialVersionUID = 1899321839025148942L;
	

	private final String message;
	private final Integer code;

	public ProductExistsException(Integer code, String message) {
		this.message = message;
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}
}