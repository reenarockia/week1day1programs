package org.college;

import week3.day1.University;

public class College extends University {
	public void collegeName() {
		System.out.println("Method to print the college name");
	}
	public void collegeCode() {
		System.out.println("Method to print the college code");
	}
	public void collegeRank() {
		System.out.println("Method to print the rank of the college");
	}
	public void ug() {
		System.out.println("implementing the method ug() in college class that extends University-Abstract class");
	}
	
	public static void main(String[] args) {
		College c1=new College();
		c1.ug();
		c1.pg();
	}

}
