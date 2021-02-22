package week1.day2;

public class SumofDigits {

	public static void main(String[] args) {
		int a=123;
		int sum=0;
		while(a !=0) {
			sum = sum+(a%10);
			a=a/10;
		}
		System.out.println("the sum of the digits="+sum);
	}

}
