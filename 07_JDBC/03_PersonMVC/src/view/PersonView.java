package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import config.ServerInfo;
import controller.PersonController;
import model.Person;

public class PersonView {

	
	
	public static void main(String[] args) {
		PersonController pc = new PersonController();
		
		// 추가

		pc.addPerson("비비빅", 25, "이마트");
		pc.addPerson("아맛나", 60, "CU");
		pc.addPerson("티코", 15, "아이스크림무인판매점");
		pc.addPerson("부라보콘", 40, "세븐일레븐");
		pc.addPerson("하겐다즈", 31, "GS25");
	

		// 전체 조회	
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
		System.out.println("====================================");
		// id로 한개 조회
		System.out.println(pc.searchPerson(3));
		
		System.out.println("====================================");
		
		// update( 1 -> name변경, 2 -> age변경,  3 -> addr변경) 업데이트
		
		pc.updatePerson(2, "18", 3);
		
		// 업데이트 확인
		list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
		
		// id로 삭제
		System.out.println("====================================");
		pc.removePerson(3);
		// 삭제 확인
		list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
	
	}
}
