package topTen.InterviewQuest;

import java.util.Scanner;

/*Reversing a string using StringBuilder concept
 * 1)create a object of a class StringBuilder
 * 2)call append method to copy the string to the StringBuilder object
 * 3)reverse the string of stringBuilder using reverse() method
 */

public class ReverseString {
	public void reversingString(String str) {
		
        StringBuilder str2 = new StringBuilder();
        str2.append(str);
        str2 = str2.reverse();
        // used string builder to reverse
       System.out.println("The reversed string is:\n"+str2);
	}

	public static void main(String[] args) {
		ReverseString str1=new ReverseString();
		Scanner scan1=new Scanner(System.in);
		System.out.println("Type the String to be reversed:\n");
		str1.reversingString(scan1.next());
		scan1.close();
		}
		

	}


