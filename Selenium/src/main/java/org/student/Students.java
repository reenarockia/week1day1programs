package org.student;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("Student id : "+ id);
	}
	public void getStudentInfo(int id,String name) {
		System.out.println(name +"'s id : "+ id);
	}
	public void getStudentInfo(long phoneNumber,String email) {
		System.out.println("Student's Phone Number: "+ phoneNumber);
		System.out.println("Student's email ID: "+ email);
	}
	public static void main(String[] args) {
		Students stud1=new Students();
		stud1.getStudentInfo(12345);
		stud1.getStudentInfo(12345, "Raja");
		stud1.getStudentInfo(9840818049l, "johnarokia@gmail.com");
	}

}
