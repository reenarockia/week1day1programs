package week1.assignments;

import java.util.Scanner;

public class Palindrome {
	public boolean isPalindrome(String str) {
		System.out.println("original String:"+str);
		char[] arr1=str.toCharArray();
		int arr_length=arr1.length;
		char[] rev=new char[arr_length];
		
		int i,j=0;
		for(i=arr1.length-1;i>=0;i--) {
			rev[j]=arr1[i];
			j++;
		}String reversedString=String.valueOf(rev);
		System.out.println("Reversed String:"+reversedString);
		if(reversedString.equalsIgnoreCase(str)) {
			return true;
		}else {
			return false;
		}
		
	}
			
	public static void main(String[] args) {
		Palindrome input1=new Palindrome();
		Scanner scan1=new Scanner(System.in);
		String x=scan1.next();
		
		if(input1.isPalindrome(x)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("not a palindrome");
		}
		scan1.close();
	}

}
