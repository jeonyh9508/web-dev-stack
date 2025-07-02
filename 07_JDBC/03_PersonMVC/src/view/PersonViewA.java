package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonControllerA;
import model.Person;
import model.PersonA;

public class PersonViewA {
	
	public static void main(String[] args) {
		
		PersonControllerA pc = new PersonControllerA();
		Scanner sc = new Scanner(System.in);
		/*
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("나이 > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("주소 > ");
		String addr = sc.nextLine();
	*/
		try {
//			pc.addPerson(name, age, addr);
			pc.searchAllPerson();
			ArrayList<PersonA> list = pc.searchAllPerson();
			for(PersonA p : list) {
				System.out.println(p);
			}
			pc.searchPerson(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
