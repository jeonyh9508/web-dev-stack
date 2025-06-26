package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Application2 {

	public static void main(String[] args) {
		// 1등 당첨 기준 -> 로또 번호 6개
		// 둘 다 랜덤 로또 번호는 1번
		// 내 번호는 맞출 때까지
	
		// 2등 당첨 보너스번호 일치 + 5개
		// 3등 당첨 5개만
		// 4등 당첨 4개만
		// 5등 당첨 3개만
		int[] result = new int[4];
		// index : 0 - 2등, 1 - 3등, 2 - 4등, 3 - 5등
		
		HashSet<Integer> lotto = new HashSet<>();
		
		while(lotto.size() < 7) {
			int random1 = (int)(Math.random()*45+1);
			lotto.add(random1);
		}
		List<Integer> lottoList = new ArrayList<>(lotto); // set -> list
		List<Integer> realLotto = lottoList.subList(0, 6);
		int bonus = lottoList.get(6);
		
		
	
		int count = 0;
		
		while(true) {
			count++;
			ArrayList<Integer> num = new ArrayList<>();
			while(num.size() < 6) {
				int random3 = (int)(Math.random()*45+1);
				if(!num.contains(random3)) {
					num.add(random3);}
			}
			
			Collections.sort(realLotto);
			Collections.sort(num);
			
			System.out.println("로또 번호 : " + realLotto);
			System.out.println("내 번호 : " + num);
			
			int check = 0;
			for(Integer number : realLotto) {
				if(num.contains(number)) {
					check++;
				}
			}
			
			if(realLotto.equals(num)) {
				System.out.println("1등 당첨 시도 횟수: " + count);
				for(int i = 0; i < result.length; i++) {
					System.out.print(" " + (i+2) + "등 당첨 횟수 : " + result[i] + "회 ");
				}
				break;
			} else if (check == 5 && num.contains(bonus)) {
				System.out.println("2등 당첨 보너스 번호 : " + bonus + ", 시도 횟수 : " + count);
				result[0]++;
			} else if (check == 5) {
				System.out.println("3등 당첨 시도 횟수 : " + count );
				result[1]++;
			} else if (check == 4) {
				System.out.println("4등 당첨 시도 횟수 : " + count );
				result[2]++;
			} else if (check == 3) {
				System.out.println("5등 당첨 시도 횟수 : " + count );
				result[3]++;
			}
		}
	}
}
