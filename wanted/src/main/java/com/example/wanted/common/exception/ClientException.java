package com.example.wanted.common.exception;

import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {
	private final ExceptionType exceptionType;

	public ClientException(ExceptionType exceptionType) {
		super(exceptionType.message());
		this.exceptionType = exceptionType;
	}
}
