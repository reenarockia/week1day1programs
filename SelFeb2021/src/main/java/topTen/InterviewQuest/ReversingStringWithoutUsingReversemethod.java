package topTen.InterviewQuest;

import java.util.Scanner;

public class ReversingStringWithoutUsingReversemethod {

	public static void main(String[] args) {
		System.out.println("Give input value:");
		Scanner scan1=new Scanner(System.in);
		String inputString=scan1.next();
		char[] charArr=inputString.toCharArray();
		String rev=""; 
		for(int i=charArr.length-1;i>=0;i--) {
			rev=rev+charArr[i];
		}System.out.println("the reversed string is:\n"+rev);
		scan1.close();
	}
}
