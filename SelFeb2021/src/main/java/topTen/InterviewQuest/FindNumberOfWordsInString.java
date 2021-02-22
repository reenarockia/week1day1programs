package topTen.InterviewQuest;

import java.util.Scanner;

public class FindNumberOfWordsInString {

	public static void main(String[] args) {
		System.out.println("Enter the input string:");
		Scanner scan1=new Scanner(System.in);
		String inputString=scan1.nextLine();
		scan1.close();
		String[] split_string=inputString.split("\\s+");
		System.out.println("number of words in the given string is: "+split_string.length);

	}

}
