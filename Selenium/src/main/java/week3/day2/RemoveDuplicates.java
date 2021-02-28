package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str="PayPal India";
		char[] charArray=str.toCharArray();
		int charArrayLength=charArray.length;
		System.out.println("Number of characters in the given String: "+charArrayLength);
		Set<Character> charSet=new LinkedHashSet<Character>();
		Set<Character> dupCharSet=new LinkedHashSet<Character>();
		for (char character : charArray) {
			if(charSet.contains(character)) {
				dupCharSet.add(character);
			}else {
				charSet.add(character);
				}
		}
		for (Character character : dupCharSet) {
			charSet.remove(character);
		}
		System.out.println("size of charset after duplicate removal: "+charSet.size());
		for (Character character2 : charSet) {
			if(!Character.isWhitespace(character2)) {
				System.out.println(character2);
			}
		} 
	}

}
