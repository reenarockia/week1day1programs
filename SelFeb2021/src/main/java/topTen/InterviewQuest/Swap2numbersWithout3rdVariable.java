package topTen.InterviewQuest;

import java.util.Scanner;

public class Swap2numbersWithout3rdVariable {

	public static void main(String[] args) {
		System.out.println("Enter the numbers to be swapped:");
		Scanner scan1=new Scanner(System.in);
		int num1=scan1.nextInt();
		int num2=scan1.nextInt();
		System.out.println("Num1: "+ num1);
		System.out.println("Num2: "+ num2);
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		System.out.println("Numbers after swapping:");
		System.out.println("Num1: "+ num1);
		System.out.println("Num2: "+ num2);
		scan1.close();
	}

}
