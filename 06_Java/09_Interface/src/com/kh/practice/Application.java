package com.kh.practice;

import java.time.LocalDate;
import java.util.Scanner;

import com.kh.practice.model.Department;
import com.kh.practice.model.UserInfo;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	UserInfo user = new UserInfo();
	

	public static void main(String[] args) {
		
		Application app = new Application();
		
		boolean check = true;
		
		while(check) {
			int select = app.employeeMenu();
			switch(select) {
				case 1:
					app.insertEmp();
					break;
				case 2:
					app.updateEmp();
					break;
				case 3:
					app.printEmp();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}
		
		
	}
	
	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.println("1. 직원 정보 추가");
		System.out.println("2. 직원 정보 수정");
		System.out.println("3. 직원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
		
	// 저장할 데이터를 사용자에게 받는 메서드
	public UserInfo insertEmp() {
		
		
		System.out.print("직원 번호 : ");
		int userNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("직원 아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("직원 비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("직원 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("직원 이름 : ");
		String name = sc.nextLine();
		
		// y일 경우만
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char choice = sc.nextLine().charAt(0);
		
		switch(choice) {
			case 'y' :	
						System.out.print("직원 전화번호 : ");
						String phone = sc.nextLine();
						
						System.out.print("직원 주소 : ");
						String addr = sc.nextLine();
						
						System.out.print("직원 성별 : ");
						String gender = sc.nextLine();
						
						System.out.print("직원 생일 (예 : 2025-06-23) : "); // LocalDate.parse(문자열) <- 문자열을 날짜로
						String birthDateInput = sc.nextLine();
						LocalDate birthDate = LocalDate.parse(birthDateInput); 
						
						System.out.print("부서 번호 입력 : ");
						
						int deptNo = Integer.parseInt(sc.nextLine());
						System.out.print("부서 등록 : "); // 너무 어렵다면 생략!	
						
						String deptName = sc.nextLine();
						Department department = new Department();
						department.setDeptName(deptName);
						department.setDeptNo(deptNo);
						
						user = new UserInfo(userNo, id, password, email, name, phone, addr, gender, birthDate, department);
						break;
			case 'n' : 
						user = new UserInfo(userNo, id, password, email, name);
						break;
			default : System.out.println("다시 입력해주세요");
		
		}
		return user;
	}
	
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("수정하려면 로그인이 필요합니다.");
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pw = sc.nextLine();
		
		if(!user.getId().equals(id) || !user.getPassword().equals(pw)) {
		// 아이디랑 비밀번호가 틀리다면!
		System.out.println("로그인 실패! 정보 수정할 수 없습니다");
		} else {
		// 아이디와 비밀번호 성공했을시에만!
		System.out.println("직원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 생일");
		System.out.println("3. 부서");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
			case 1:
				System.out.print("전화 번호 입력 : ");
				String phone = sc.nextLine();
				
				user.setPhone(phone);
				break;
			case 2:
				System.out.print("생일 입력 (예 : 2025-06-23) : ");
				String birthDateInput = sc.nextLine();
				
				LocalDate birthDate = LocalDate.parse(birthDateInput); 
				user.setBirthDate(birthDate);
				break;
			case 3:
				System.out.print("부서 번호 입력 : ");
				int deptNo = Integer.parseInt(sc.nextLine());
				
				System.out.print("부서 입력 : ");
				String deptName = sc.nextLine();
				
				Department department = new Department();
				department.setDeptName(deptName);
				department.setDeptNo(deptNo);
				user.setDepartment(department);
				break;
			case 9:
				break;
			}
		}
	}
	
	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(user);
	}
}