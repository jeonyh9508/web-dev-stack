package com.kh.exception.practice2.exception;

public class DuplicateIdException extends Exception{

	public DuplicateIdException() {
		this("중복된 사람이 있습니다 에러발생");
	}
	
	public DuplicateIdException(String message) {
		super(message);
	}
}
