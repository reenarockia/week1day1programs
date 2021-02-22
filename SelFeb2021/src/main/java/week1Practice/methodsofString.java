package week1Practice;

public class methodsofString {

	public static void main(String[] args) {
		String a="Welcome to my home";
		String b="Welcome";
		String c="Welcome";
		String d="home";
		String e="";
		System.out.println(a.charAt(2));// the output is the char at the index 2
		System.out.println(a.codePointAt(4));//unicode of the char at the index 2
		System.out.println((a.codePointBefore(4)));
		System.out.println(a.codePointCount(0, 6));
		System.out.println(a.compareTo(b));//lexicographically? the value 0 if the argument string is equal tothis string; 
		//a value less than 0 if this stringis lexicographically less than the string argument; 
		//and avalue greater than 0 if this string islexicographically greater than the string argument.
		System.out.println(a.compareToIgnoreCase("HOME"));//returns a negative integer, zero, 
		//or a positive integer as thespecified String is greater than, equal to, or lessthan this String,
		//ignoring case considerations
		System.out.println(a.concat(b));//returns a string that represents the concatenation of 
		//this object'scharacters followed by the string argument's characters.
		System.out.println(a.contains(b));//returns true or false
		System.out.println(a.contentEquals(b));//returns true if this String represents the 
		//samesequence of char values as the specified sequence, false otherwise
		System.out.println(b.contentEquals(c));
		System.out.println(a.endsWith(d));//true if the character sequence represented by the argument is a 
		//suffix of the character sequence
		//represented bythis object; false otherwise. Note that theresult will be true if the argument is theempty
		//string or is equal to this String objectas determined by the equals(Object) method.
		System.out.println(a.endsWith(e));//passing an empty string - returns true
		System.out.println(a.equals(c));//returns true if the string passed is same as that of the string compared with
		System.out.println(a.equalsIgnoreCase("HOME"));
		System.out.println(a.equalsIgnoreCase("WELCOME TO MY HOME"));
}
}
