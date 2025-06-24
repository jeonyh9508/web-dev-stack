package com.kh.practice.model;

public class Department {

	private int deptNo;
	private String deptName;
	
	public Department(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public Department() {
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "부서 번호 = " + deptNo + ", 부서 명 = " + deptName + "]";
	}

	
}
