package week3.day1;

public class Calculator {
	public int add(int num1,int num2) {
		System.out.println("Adding 2 numbers using method add. Sum= ");
		return(num1+num2);
	}
	public int add(int num1,int num2,int num3) {
		System.out.println("Adding 3 numbers using method add. Sum= ");
		return(num1+num2+num3);
	}
	public int multiply(int num1,int num2) {
		System.out.println("Multiplying 2 numbers using method multiply. Product= ");
		return(num1*num2);
	}
	public double multiply(int num1,double num2) {
		System.out.println("Multiplying 2 numbers(int and double) using method multiply. Product= ");
		return(num1*num2);
	}
	public int subtract(int num1,int num2) {
		System.out.println("Subtraction using 2 numbers of int, using method subtract. Difference= ");
		return(num1-num2);
	}
	public double subtract(double num1,double num2) {
		System.out.println("Subtraction using 2 numbers of double, using method subtract. Difference= ");
		return(num1-num2);
	}
	public int divide(int num1,int num2) {
		System.out.println("Division with 2 int arguments.Quotient = ");
		return(num1/num2);
	}
	public double divide(double num1,int num2) {
		System.out.println("Division with 2 int arguments.Quotient = ");
		return(num1/num2);
	}
	public static void main(String[] args) {
		Calculator c1=new Calculator();
		System.out.println(c1.add(10, 20));
		System.out.println(c1.add(20, 40, 100));
		System.out.println(c1.multiply(5, 20));
		System.out.println(c1.multiply(5, 2.5));
		System.out.println(c1.subtract(100, 10));
		System.out.println(c1.subtract(50.5, 10.2));
		System.out.println(c1.divide(10,5));
		System.out.println(c1.divide(25.5, 5));
	}
}
