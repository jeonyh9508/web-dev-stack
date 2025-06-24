package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;

public class PolymorphismController {

	/*
	public void find(Employee[] emp, String name) {
		for(int i = 0; i < emp.length; i++) {
			if(emp[i].getName().equals(name)) {
				System.out.println(emp[i]);
				}
			}
	}
	*/
	
	public Employee findEmployee(Employee[] emp, String name) {
		for (Employee employee : emp) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}
	/*
	public void getAnnualSalary(Employee[] emp, String name) {
		for(int i = 0; i < emp.length; i++) {
			if(emp[i].getName().equals(name)) {
				System.out.println(emp[i].getName()+ " 의 연봉은 " +(emp[i].getSalary()) * 12);
				}
			}
	}
	*/
	public int getAnnualSalary(Employee findEmployee) {
		if(findEmployee == null) return -1;
		
		if (findEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) findEmployee;
			return engineer.getSalary() * 12 + engineer.getBonus();
		}
			return findEmployee.getSalary() * 12;
		}
	/*
	public int total_salary(Employee[] emp) {
		int sum = 0;
		for(int i = 0; i < emp.length; i++) {
			sum += emp[i].getSalary();
		}return sum;
	}
*/
	public int totalSalary(Employee[] emp) {
		int sum = 0;
		for (Employee employee : emp) {
			sum += employee.getSalary();
		}
		return sum;
	}
}
