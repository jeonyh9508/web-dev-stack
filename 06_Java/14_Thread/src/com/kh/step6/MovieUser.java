package com.kh.step6;

// 영화관에서 좌석을 예매하는 일을 전담하는 스레드
public class MovieUser implements Runnable{

	private boolean seat = false; // 좌석예매 끝나면 true
	
	@Override
	public synchronized void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "님, 예매하러 오셨군요");
		
		if(seat == false) {
			System.out.println(name + "님, 예매 성공");
			seat = true;
		} else {
			System.out.println(name + "님, 해당 좌석은 예매완료된 좌석입니다.");
		}
	}

}
