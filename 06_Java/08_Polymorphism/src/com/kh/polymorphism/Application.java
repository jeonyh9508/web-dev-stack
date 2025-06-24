package com.kh.polymorphism;


import java.util.Scanner;

import com.kh.polymorphism.controller.PolymorphismController;
// FQCN (Full Qualified Class Name)
import com.kh.polymorphism.model.*;

/*
	다형성(Polymorphism)
	- 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
	- 부모 타입으로 자식 객체를 생성하는 것
	
	SOLID의 L ->	Liskov Substitution Principle, LSP
	- 부모 객체는 자식 객체로 교체해도 문제 없다
	- 다형성이 제대로 설계되었는지 판단하는 기준 중 하나
*/
public class Application {

	
	
	public static void main(String[] args) {
		
	
		
		Employee em = new Employee("문채은", 3000000);
		Employee en = new Engineer("최다인", 3500000, "자바", 300000);
		Employee ma = new Manager("김은진", 4000000, "개발팀");
		Employee se = new Secretary("전영현", 4500000, "문채은");
		/*
		System.out.println(em);
		System.out.println(en);
		System.out.println(ma);
		System.out.println(se);
		*/
		
		// 다형성 + 객체 배열
		
		
		Employee[] emp = {em, en, ma, se};
		/*
		for(Employee employee : emp) {
			System.out.println(employee);
		}
		*/
		// 이름으로 사람 찾기
	/*
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();	
		pc.find(emp, name);
	*/
		/*
		Employee findEmployee = null;
		for(Employee employee : emp) {
			if(employee.getName().equals("전영현")) {
			System.out.println(employee);
				findEmployee = employee;
			}
		}
		*/
		Scanner sc = new Scanner(System.in);
		PolymorphismController pc = new PolymorphismController();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		Employee findEmployee = pc.findEmployee(emp, name);

		
		
		// 찾은 사람의 연봉(getSalary)은?
		int annual = pc.getAnnualSalary(findEmployee);
		if(annual != -1) {
		System.out.println(pc.getAnnualSalary(findEmployee));
		}
	/*
		pc.getAnnualSalary(emp, name);
	*/
		// 특정 자식 객체 찾는 법 (instanceof)
		/*
		if(findEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) findEmployee;
			System.out.println(findEmployee.getSalary()*12 + engineer.getBonus());
		} else {System.out.println(findEmployee.getSalary()*12);
		}
		*/
		
		
		// 전체 총 월급 -> for 문을 통해 getSalary 더하기
		/*
		System.out.println("전체 총 월급 : " + pc.total_salary(emp));
		 */
		/*
		int sum = 0;
		for(Employee employee : emp) {
			sum += employee.getSalary();
		}System.out.println(sum);
		*/
		
		System.out.println(pc.totalSalary(emp));
	}

}
