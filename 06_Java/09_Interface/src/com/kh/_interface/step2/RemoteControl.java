package com.kh._interface.step2;
// 인터페이스 끼리는 extends 다중상속
public interface RemoteControl extends Volume, Searchable{

	void turnOn();
	void turnOff();
	
	
}
