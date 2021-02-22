package week1.assignments;

public class Person {
	//class variables:characters of the person or information about the person 
	String default_statement="Printing the person info:";
	
	
	//Method is a block of code to perform certain action
	public void printPersonInfo(String name,int age,String color,String gender) {
		System.out.println(default_statement);
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
		System.out.println("Color:"+color);
		System.out.println("Gender:"+gender);
		
		}

	public static void main(String[] args) {
		/* Object creation. By using this single reference, we can print 'n' number of
		persons' informations */
		Person person1=new Person();
		person1.printPersonInfo("John",40,"brown","Male");
		System.out.println("\n");
		person1.printPersonInfo("Juana",10,"brown","Female");
	}
}
