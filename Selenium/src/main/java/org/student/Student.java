package org.student;

import org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Method to print the student name");
	}
	public void studentDept() {
		System.out.println("Method to print the Student Department name");
	}
	public void studentId() {
		System.out.println("Method to print Student ID");
	}
	  
	public static void main(String[] args) {
		Student s1=new Student();
		s1.collegeName();
		s1.collegeCode();
		s1.collegeRank();
		s1.deptname();
		s1.studentDept();
		s1.studentId();
		s1.studentName();
	}

}
