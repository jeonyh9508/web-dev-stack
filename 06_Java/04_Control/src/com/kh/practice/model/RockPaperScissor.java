package com.kh.practice.model;

import java.util.Arrays;


// 캡슐화 ! -> SRP원칙 (Single Responsibility Principle)
public class RockPaperScissor {
	private String[] rps ={ "가위", "바위", "보"};
	private int win = 0;
	private int lose = 0;
	private int draw = 0;
	
	// Generate Constructors from Superclass
	public RockPaperScissor() {
		
	}

	// Generate Constructor using Fields...
	public RockPaperScissor(String[] rps, int win, int lose, int draw) {
		super();
		this.rps = rps;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}

	// Generate Getters and Setters...
	public String[] getRps() {
		return rps;
	}


	public void setRps(String[] rps) {
		this.rps = rps;
	}


	public int getWin() {
		return win;
	}


	public void setWin(int win) {
		this.win = win;
	}


	public int getLose() {
		return lose;
	}


	public void setLose(int lose) {
		this.lose = lose;
	}


	public int getDraw() {
		return draw;
	}


	public void setDraw(int draw) {
		this.draw = draw;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "RockPaperScissor [rps=" + Arrays.toString(rps) + ", win=" + win + ", lose=" + lose + ", draw=" + draw
				+ "]";
	}
	
	// alt + shift + s
	// Generate Constructors from Superclass
	// Generate Constructor using Fields...
	// Generate Getters and Setters... (Select All)
	// Generate toString()
	
}
