package com.goodmann.wordcardapi.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;

@ControllerAdvice
public class ExceptionController extends RuntimeException {

	private static final long serialVersionUID = 1862107300089042316L;

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ErrorResponse> exception(BusinessException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMsg());
		error.setStatus(ErrorStatus.BUSINESS_ERROR);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Getter
	@Setter
	public class ErrorResponse {
		private LocalDate data = LocalDate.now();
		private String message;
		private ErrorStatus status;
	}

	public enum ErrorStatus {
		BUSINESS_ERROR;
	}

}
