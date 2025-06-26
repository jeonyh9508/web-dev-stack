package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		// 1등 당첨 기준 -> 로또 번호 6개
		// 둘 다 랜덤 로또 번호는 1번
		// 내 번호는 맞출 때까지
	
		// 2등 당첨 보너스번호 일치 + 5개
		// 3등 당첨 5개만
		// 4등 당첨 4개만
		// 5등 당첨 3개만
		HashSet<Integer> lotto = new HashSet<>();
		int count = 0;
		
		while(lotto.size() < 6) {
			int random1 = (int)(Math.random()*45+1);
			lotto.add(random1);
		}
		System.out.println("로또 번호 : " + lotto);
		List<Integer> lottoList = new ArrayList<>(lotto); // set -> list
		Collections.sort(lottoList);
		System.out.println(lottoList);
		
		
		/*
		TreeSet<Integer> lotto = new TreeSet<>();
		long count = 0l;
		
		while(lotto.size() < 6) {
			int random1 = (int)(Math.random()*45+1);
			lotto.add(random1);
		}
		
//		System.out.println("로또 번호 : " + lotto);
		List<Integer> lottoList = new ArrayList<>(lotto);
		*/
		
		ArrayList<Integer> num = new ArrayList<>();
		/*
		while(num.size() < 6){
			int random2 = (int)(Math.random()*45+1);
			if(!num.contains(random2)) {
			num.add(random2);}
		}
		*/
			
//			System.out.println("내 번호 : " + num);	
		
		while(true) {
			num.clear();
			while(num.size() < 6) {
				int random3 = (int)(Math.random()*45+1);
				if(!num.contains(random3)) {
					num.add(random3);}
			}
			Collections.sort(num);
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 번호 : " + num);
			count++;
			
			if(lottoList.equals(num)) {
				System.out.println("시도 횟수 : " + count);
				break;
			}
			}
			
		
	}
}
