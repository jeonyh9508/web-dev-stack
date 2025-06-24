package com.kh._abstract.step1;

public class FootBall extends Sports {

	public FootBall(int numOfPlayers) {
		super(numOfPlayers);
	}

	@Override
	public void rule() {
		System.out.println("FootBall의 선수 수는 " + this.numOfPlayers + "명, 공을 발로 차서 골대 안에 넣는다");
	}

	
}
