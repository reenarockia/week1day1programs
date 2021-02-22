package week1.assignments;

import java.util.Scanner;

public class Factorial {
	public void checkFactors(int numto_check) {
		int i;
		for(i=1;i<=numto_check;i++) {
			if(numto_check%i == 0) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		Factorial fact=new Factorial();
		Scanner scan1=new Scanner(System.in);
		int x=scan1.nextInt();
		scan1.close();
		System.out.println("The factors of "+x+" are:");
		fact.checkFactors(x);
	}

}
