package com.kh._abstract.step1;

// 추상 클래스 public abstract class
public abstract class Sports {

	protected int numOfPlayers; // 참여 사람 수

	public Sports(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	// 추상 메서드 -> 미완성된 메서드 / 구현부 X -> 자식 클래스에서 강제로 구현
	// 추상 메서드를 갖으려면, 클래스가 추상클래스
	public abstract void rule ();
	
}
