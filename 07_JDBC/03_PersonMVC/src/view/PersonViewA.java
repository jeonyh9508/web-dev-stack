package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonControllerA;
import vo.PersonA;

public class PersonViewA {

	PersonControllerA pc = new PersonControllerA();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	PersonViewA view = new PersonViewA();
	
		view.menu();
		
	}
	
	public void menu() {
		while (true) {
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 아이디 조회");
			System.out.println("4. 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1: 
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3: 
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5:
				System.out.println(removePerson());
				break;
			}
			}
	}
	
	public String addPerson() {
		try {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("나이 > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("주소 > ");
		String addr = sc.nextLine();
		
		return pc.addPerson(name, age, addr);
		// 1인 경우가 추가
			
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요 ";
		}
	}
	
	public void searchAllPerson() {
			List<PersonA> list = pc.searchAllPerson();
			if(list != null) {
			for (PersonA p : list) {
				System.out.println(p);
			}
		}
	}
	
	public void searchPerson() {
		searchAllPerson();
		System.out.print("아이디 선택 > ");
		int id = Integer.parseInt(sc.nextLine());
		PersonA person = pc.searchPerson(id);
		if(person != null) {
			System.out.println(person + "이 조회되었습니다.");}
		else {
			System.out.println("회원 정보 없음");
		}
	}
	
	public String updatePerson() {
		searchAllPerson();
		System.out.print("아이디 선택 > ");
		int id = Integer.parseInt(sc.nextLine());
		PersonA person = pc.searchPerson(id);
		if(person == null) return "아이디 조회 실패";
		
		System.out.print("수정할 이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("수정할 나이 입력 > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 주소 입력 > ");
		String addr = sc.nextLine();
		
		return pc.updatePerson(name, age, addr, id);
	}
	
	public String removePerson() {
			System.out.print("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());
			
			PersonA person;
			person = pc.searchPerson(id);
			if(person == null) return "아이디 조회 실패";
			
			return pc.removePerson(id);
		
	}
}
