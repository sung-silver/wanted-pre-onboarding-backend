package com.example.wanted.common.exception;

import static com.example.wanted.common.exception.exceptionType.CommonExceptionType.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String> handleCustomException(ClientException ex) {
		return ResponseEntity.status(ex.getExceptionType().status()).body(ex.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleServerException(RuntimeException ex) {
		log.error("🚨 InternalException occurred: {} 🚨", ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(INTERNAL_SERVER_ERROR.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NoHandlerFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(NOT_FOUND_PATH.getMessage() + ": " + ex.getRequestURL());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationError(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		StringBuilder builder = new StringBuilder();

		if (bindingResult.hasErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				builder.append("[")
					.append(fieldError.getField())
					.append("](은)는 ")
					.append(fieldError.getDefaultMessage())
					.append(" 입력된 값: [")
					.append(fieldError.getRejectedValue())
					.append("] ");
			}
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(INVALID_INPUT_VALUE.getMessage() + ": " + builder);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleMethodArgumentTypeMismatchException(
		MethodArgumentTypeMismatchException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(INVALID_INPUT_VALUE.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<String> handleHttpMediaTypeNotSupportedException() {
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
			.body(INVALID_JSON_TYPE.getMessage());
	}
}
