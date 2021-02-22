package topTen.InterviewQuest;

import java.util.Scanner;

public class NumberSwap {
	
	static Scanner scan1=new Scanner(System.in);
	static int num1=scan1.nextInt();
	static int num2=scan1.nextInt();

		public void swappingnumbers(int num1,int num2) {
		
			int temp;
			System.out.println("Numbers Before swapping:");
			System.out.println("num1:"+num1);
			System.out.println("num2:"+num2);
			temp=num1;
			num1=num2;
			num2=temp;
			System.out.println("Numbers after swapping:");
			System.out.println("num1:"+num1);
			System.out.println("num2:"+num2);
	}

	public static void main(String[] args) {
		NumberSwap set1=new NumberSwap();
		set1.swappingnumbers(num1, num2);
		scan1.close();
	}

}
