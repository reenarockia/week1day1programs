package week1.assignments;

public class Occurance {

	public static void main(String[] args) {
		String str = "welcome to chennai";
		int i=0,number_ofOccurance=0;
		while(i<str.length()) {
			if(str.charAt(i)=='e') {
				number_ofOccurance++;
				}i++;
		}System.out.println("Number of occurance of 'e' is:"+number_ofOccurance);
	}

}
