package com.kh.exception.practice2.exception;

public class RecordNotFoundException extends Exception {
	
	public RecordNotFoundException() {
		this("회원 정보가 없음 에러 발생");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}
