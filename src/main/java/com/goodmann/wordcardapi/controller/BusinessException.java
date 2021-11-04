package com.goodmann.wordcardapi.controller;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8520011334983489602L;

	private String msg;

	public BusinessException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
