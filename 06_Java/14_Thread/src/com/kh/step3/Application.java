package com.kh.step3;

import java.awt.Toolkit;

public class Application {

	public static void main(String[] args) {
/*
		// 첫번째 작업 - 경고음 5번 울리기 -> BeepThread
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 두번째 작업 - 띵~ 5번 출력 -> TextThreads
		for(int i = 0; i < 5; i++) {
			System.out.println("띵 ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
*/
		
		Thread beep = new Thread(new BeepThread());
		Thread text = new Thread(new TextThread());
		
		beep.start();
		text.start();
	}

}
