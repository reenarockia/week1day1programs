package week1.assignments;

import java.util.HashSet;
import java.util.Set;

public class NoDuplicates {
	
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String[] split_string=text.split("\\s+");
		System.out.println("Number of words in this text:"+ split_string.length);
		for (String string : split_string) {
			System.out.println(string);
		}Set<String> myset=new HashSet<String>();
		for (String string : split_string) {
			if(myset.add(string)==false) {
				
				count=count+1;
				
			}if (count > 1) {
				System.out.println(string+" has duplicate values");
				count=0;
			}
		}System.out.println(myset);
		
	}
}
