package com.example.wanted.common.exception.exceptionType;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CompanyException implements ExceptionType{
	// 404 Not Found
	NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND, "요청하신 기업을 찾을 수 없습니다");

	private final HttpStatus status;
	private final String message;

	@Override
	public HttpStatus status() {
		return this.status;
	}

	@Override
	public String message() {
		return this.message;
	}
}
